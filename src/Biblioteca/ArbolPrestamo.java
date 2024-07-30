package Biblioteca;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ArbolPrestamo {

    //Se definen atributos
    NodoPrestamo raiz;
    int tamano;

    //Constructor
    public ArbolPrestamo() {
        this.raiz = null;
        this.tamano = 0;
    }
    
    //Metodos get y set

    public NodoPrestamo getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoPrestamo raiz) {
        this.raiz = raiz;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    //Metodo para insertar un prestamo nuevo
    public void insertarPrestamo(int id, String fecha, int idUsuario, int idLibro) {
        Prestamo info = new Prestamo(id,fecha,idUsuario, idLibro);
        if (raiz == null) {
            raiz = new NodoPrestamo(info);
            tamano++;
        } else {
            NodoPrestamo aux = raiz;
            boolean cont = true;
            while (cont) {
                if (info.getIdPrestamo() < aux.getInformacion().getIdPrestamo()) {
                    if (aux.getIzq() != null) {
                        aux = aux.getIzq();
                    } else {
                        aux.setIzq(new NodoPrestamo(info, aux));
                        tamano++;
                        cont = false;
                    }
                } else {
                    if (aux.getDer() != null) {
                        aux = aux.getDer();
                    } else {
                        aux.setDer(new NodoPrestamo(info, aux));
                        tamano++;
                        cont = false;
                    }
                }
            }
        }
    }
    
    //Metodo para buscar un prestamo nuevo
    public NodoPrestamo buscarPrestamo(int info) {
        NodoPrestamo aux = raiz;
        while (aux != null) {
            if (aux.getInformacion().getIdPrestamo()== info) 
                return aux;
            if (info < aux.getInformacion().getIdPrestamo()) 
                aux = aux.getIzq();
            else
                aux = aux.getDer();
        }
        return aux;
    }
    
    //Metodo para mostrar prestamo
    public void mostrarPrestamo(int info) {
        NodoPrestamo aux = buscarPrestamo(info);
        if (aux != null) {
            JOptionPane.showMessageDialog(null, 
                    "ID: "+aux.getInformacion().getIdPrestamo()
                    +" | ID Usuario: "+aux.getInformacion().getIdUsuarioPrestamo()
                    +" | ID Libro: "+aux.getInformacion().getIdLibroPrestamo()
                    +" | Fecha Prestamo: "+aux.getInformacion().getFechaPrestamo());
        }
        else{
            JOptionPane.showMessageDialog(null,"El prestamo no se encuentra");
        }
    }
    
    //Metodo para listar prestamos
    public void listarPrestamos() {
        String lista = "";
        lista = listarPrestamos(raiz, lista);
        JOptionPane.showMessageDialog(null, "Lista de Prestamos\n\n"+lista);
    }

    //Metodo para listar prestamos
    private String listarPrestamos(NodoPrestamo n, String tex) {
        if(n!=null){
            tex = listarPrestamos(n.getIzq(),tex);
            tex += "ID: "+n.getInformacion().getIdPrestamo()
                    +" | ID Usuario: "+n.getInformacion().getIdUsuarioPrestamo()
                    +" | ID Libro: "+n.getInformacion().getIdLibroPrestamo()
                    +" | Fecha Prestamo: "+n.getInformacion().getFechaPrestamo()
                    +"\n";
            tex = listarPrestamos(n.getDer(),tex);
        }
        return tex;
    }
    
    //Metodo para array de Id prestamo
    public ArrayList<Integer> arregloPrestamos(){
        ArrayList<Integer> arreglo = new ArrayList<>();
        return arregloPrestamos(raiz,arreglo);
    }
    
    private ArrayList<Integer> arregloPrestamos(NodoPrestamo n,ArrayList<Integer> arreglo){
        if(n !=null){
            arreglo = arregloPrestamos(n.getIzq(),arreglo);
            arreglo.add(n.getInformacion().getIdPrestamo());
            arreglo = arregloPrestamos(n.getDer(),arreglo);
        }
        return arreglo;
    }
    
    //Metodo para validar si es hoja
    private boolean esHoja(NodoPrestamo aux) {
        if (aux.getIzq() == null && aux.getDer() == null) {
            return true;
        }
        return false;
    }

    //Metodo para validar si tiene un hijo
    private boolean tieneUnHijo(NodoPrestamo aux) {
        if ((aux.getIzq() == null && aux.getDer() != null) || (aux.getIzq() != null && aux.getDer() == null)) {
            return true;
        }
        return false;
    }

    //Metodo para eliminar hoja
    private void eliminarHoja(NodoPrestamo aux) {
        if (aux.getPadre() == null) {
            raiz = null;
        } else {
            if (aux == aux.getPadre().getIzq()) {
                aux.getPadre().setIzq(null);
            } else {
                aux.getPadre().setDer(null);
            }
        }
    }

    //Metodo para eliminar un hijo
    private void eliminarUnHijo(NodoPrestamo aux) {
        if (aux == raiz) {
            if (aux.getIzq() != null) {
                raiz = aux.getIzq();
            } else {
                raiz = aux.getDer();
            }
            raiz.setPadre(null);
        }
        else{
            if (aux.getIzq() != null) {
                if(aux == aux.getPadre().getIzq())
                    aux.getPadre().setIzq(aux.getIzq());
                else
                    aux.getPadre().setDer(aux.getIzq());
                aux.getIzq().setPadre(aux.getIzq());
            }
            else{
                if(aux == aux.getPadre().getIzq())
                    aux.getPadre().setIzq(aux.getDer());
                else
                    aux.getPadre().setDer(aux.getDer());   
                aux.getDer().setPadre(aux.getIzq());
            }
        }
    }

    //Metodo para eliminar dos hijos
    private void eliminarDosHijos(NodoPrestamo aux) {
        NodoPrestamo mayor = buscarMayor(aux.getIzq());
        aux.setInformacion(mayor.getInformacion());
        if(esHoja(mayor))
            eliminarHoja(mayor);
        else
            eliminarUnHijo(mayor);
    }
    
    //Metodo para buscar hijo mayor
    private NodoPrestamo buscarMayor(NodoPrestamo m){
        while(m.getDer()!=null)
            m = m.getDer();
        return m;
    }

    //Metodo para eliminar prestamo
    public void eliminarPrestamo(int info) {
        NodoPrestamo aux = buscarPrestamo(info);
        if (aux != null) {
            if (esHoja(aux)) {
                eliminarHoja(aux);
            } else if (tieneUnHijo(aux)) {
                eliminarUnHijo(aux);
            } else {
                eliminarDosHijos(aux);
            }
            tamano--;
            JOptionPane.showMessageDialog(null, "Prestamo borrado");
        } else {
            JOptionPane.showMessageDialog(null, "El prestamo no se encuentra");
        }
    }
}
