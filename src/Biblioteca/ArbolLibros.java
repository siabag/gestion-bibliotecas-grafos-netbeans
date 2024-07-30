package Biblioteca;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ArbolLibros {

    //Se definen atributos
    NodoLibro raiz;
    int tamano;

    //Constructor
    public ArbolLibros() {
        this.raiz = null;
        this.tamano = 0;
    }
    
    //Metodos get y set

    public NodoLibro getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoLibro raiz) {
        this.raiz = raiz;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
    
    //Metodo para insertar un libro nuevo
    public void insertarLibro(int id, String nombre, String autor) {
        Libro info = new Libro(id, nombre, autor);
        if (raiz == null) {
            raiz = new NodoLibro(info);
            tamano++;
        } else {
            NodoLibro aux = raiz;
            boolean cont = true;
            while (cont) {
                if (info.getIdLibro() < aux.getInformacion().getIdLibro()) {
                    if (aux.getIzq() != null) {
                        aux = aux.getIzq();
                    } else {
                        aux.setIzq(new NodoLibro(info, aux));
                        tamano++;
                        cont = false;
                    }
                } else {
                    if (aux.getDer() != null) {
                        aux = aux.getDer();
                    } else {
                        aux.setDer(new NodoLibro(info, aux));
                        tamano++;
                        cont = false;
                    }
                }
            }
        }
    }

    //Metodo para buscar un libro nuevo
    private NodoLibro buscarLibro(int info) {
        NodoLibro aux = raiz;
        while (aux != null) {
            if (aux.getInformacion().getIdLibro() == info) {
                return aux;
            }
            if (info < aux.getInformacion().getIdLibro()) {
                aux = aux.getIzq();
            } else {
                aux = aux.getDer();
            }
        }
        return aux;
    }
    
    //Metodo para validar un libro
    public boolean validarLibro(int info) {
        NodoLibro aux = raiz;
        while (aux != null) {
            if (aux.getInformacion().getIdLibro() == info) {
                return true;
            }
            if (info < aux.getInformacion().getIdLibro()) {
                aux = aux.getIzq();
            } else {
                aux = aux.getDer();
            }
        }
        return false;
    }

    //Metodo para mostrar libro
    public void mostrarLibro(int info) {
        NodoLibro aux = buscarLibro(info);
        if (aux != null) {
            JOptionPane.showMessageDialog(null,
                    "ID: " + aux.getInformacion().getIdLibro()
                    + " | Nombre: " + aux.getInformacion().getNombreLibro()
                    + " | Autor: " + aux.getInformacion().getAutorLibro());
        } else {
            JOptionPane.showMessageDialog(null, "El libro no se encuentra");
        }
    }

    //Metodo para listar libros
    public void listarLibros() {
        String lista = "";
        lista = listarLibros(raiz, lista);
        JOptionPane.showMessageDialog(null, "Lista de libros\n\n" + lista);
    }

    //Metodo para listar libros
    private String listarLibros(NodoLibro n, String tex) {
        if (n != null) {
            tex = listarLibros(n.getIzq(), tex);
            tex += "ID: " + n.getInformacion().getIdLibro()
                    + " | Nombre: " + n.getInformacion().getNombreLibro()
                    + " | Autor: " + n.getInformacion().getAutorLibro()
                    + "\n";
            tex = listarLibros(n.getDer(), tex);
        }
        return tex;
    }
    
    //Metodo para array de Id libros
    public ArrayList<Integer> arregloLibros(){
        ArrayList<Integer> arreglo = new ArrayList<>();
        return arregloLibros(raiz,arreglo);
    }
    
    private ArrayList<Integer> arregloLibros(NodoLibro n,ArrayList<Integer> arreglo){
        if(n !=null){
            arreglo = arregloLibros(n.getIzq(),arreglo);
            arreglo.add(n.getInformacion().getIdLibro());
            arreglo = arregloLibros(n.getDer(),arreglo);
        }
        return arreglo;
    }

    //Metodo para validar si es hoja
    private boolean esHoja(NodoLibro aux) {
        if (aux.getIzq() == null && aux.getDer() == null) {
            return true;
        }
        return false;
    }

    //Metodo para validar si tiene un hijo
    private boolean tieneUnHijo(NodoLibro aux) {
        if ((aux.getIzq() == null && aux.getDer() != null) || (aux.getIzq() != null && aux.getDer() == null)) {
            return true;
        }
        return false;
    }

    //Metodo para eliminar hoja
    private void eliminarHoja(NodoLibro aux) {
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
    private void eliminarUnHijo(NodoLibro aux) {
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
    private void eliminarDosHijos(NodoLibro aux) {
        NodoLibro mayor = buscarMayor(aux.getIzq());
        aux.setInformacion(mayor.getInformacion());
        if(esHoja(mayor))
            eliminarHoja(mayor);
        else
            eliminarUnHijo(mayor);
    }
    
    //Metodo para buscar hijo mayor
    private NodoLibro buscarMayor(NodoLibro m){
        while(m.getDer()!=null)
            m = m.getDer();
        return m;
    }

    //Metodo para eliminar libro
    public void eliminarLibro(int info) {
        NodoLibro aux = buscarLibro(info);
        if (aux != null) {
            if (esHoja(aux)) {
                eliminarHoja(aux);
            } else if (tieneUnHijo(aux)) {
                eliminarUnHijo(aux);
            } else {
                eliminarDosHijos(aux);
            }
            tamano--;
            JOptionPane.showMessageDialog(null, "Libro borrado");
        } else {
            JOptionPane.showMessageDialog(null, "El libro no se encuentra");
        }
    }
}
