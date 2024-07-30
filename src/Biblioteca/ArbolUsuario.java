package Biblioteca;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ArbolUsuario {

    //Se definen atributos
    NodoUsuario raiz;
    int tamano;

    //Constructor
    public ArbolUsuario() {
        this.raiz = null;
        this.tamano = 0;
    }
    
    //Metodos get y set

    public NodoUsuario getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoUsuario raiz) {
        this.raiz = raiz;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    //Metodo para insertar un usuario nuevo
    public void insertarUsuario(int id, String nombre, String apellido, int telefono) {
        Usuario info = new Usuario(id,nombre,apellido,telefono);
        if (raiz == null) {
            raiz = new NodoUsuario(info);
            tamano++;
        } else {
            NodoUsuario aux = raiz;
            boolean cont = true;
            while (cont) {
                if (info.getIdUsuario() < aux.getInformacion().getIdUsuario()) {
                    if (aux.getIzq() != null) {
                        aux = aux.getIzq();
                    } else {
                        aux.setIzq(new NodoUsuario(info, aux));
                        tamano++;
                        cont = false;
                    }
                } else {
                    if (aux.getDer() != null) {
                        aux = aux.getDer();
                    } else {
                        aux.setDer(new NodoUsuario(info, aux));
                        tamano++;
                        cont = false;
                    }
                }
            }
        }
    }

    //Metodo para buscar un usuario
    private NodoUsuario buscarUsuario(int info) {
        NodoUsuario aux = raiz;
        while (aux != null) {
            if (aux.getInformacion().getIdUsuario() == info) {
                return aux;
            }
            if (info < aux.getInformacion().getIdUsuario()) {
                aux = aux.getIzq();
            } else {
                aux = aux.getDer();
            }
        }
        return aux;
    }
    
    //Metodo para validar un usuario
    public boolean validarUsuario(int info) {
        NodoUsuario aux = raiz;
        while (aux != null) {
            if (aux.getInformacion().getIdUsuario() == info) {
                return true;
            }
            if (info < aux.getInformacion().getIdUsuario()) {
                aux = aux.getIzq();
            } else {
                aux = aux.getDer();
            }
        }
        return false;
    }
    
    //Metodo para mostrar usuario
    public void mostrarUsuario(int info) {
        NodoUsuario aux = buscarUsuario(info);
        if (aux != null) {
            JOptionPane.showMessageDialog(null,
                    "ID: "+aux.getInformacion().getIdUsuario()
                    +" | Nombre: "+aux.getInformacion().getNombreUsuario()
                    +" | Apellido: "+aux.getInformacion().getApellidoUsuuario()
                    +" | Telefono: "+aux.getInformacion().getTelefonoUsuario());
        }
        else{
            JOptionPane.showMessageDialog(null,"El usuario no se encuentra");
        }
    }

    //Metodo para listar usuarios
    public void listarUsuarios() {
        String lista = "";
        lista = listarUsuarios(raiz, lista);
        JOptionPane.showMessageDialog(null, "Lista de Usuarios\n\n"+lista);
    }

    //Metodo para listar usuarios
    private String listarUsuarios(NodoUsuario n, String tex) {
        if(n!=null){
            tex = listarUsuarios(n.getIzq(),tex);
            tex += "ID: "+n.getInformacion().getIdUsuario()
                    +" | Nombre: "+n.getInformacion().getNombreUsuario()
                    +" | Apellido: "+n.getInformacion().getApellidoUsuuario()
                    +" | Telefono: "+n.getInformacion().getTelefonoUsuario()
                    +"\n";
            tex = listarUsuarios(n.getDer(),tex);
        }
        return tex;
    }
    
    //Metodo para array de Id prestamo
    public ArrayList<Integer> arregloUsuarios(){
        ArrayList<Integer> arreglo = new ArrayList<>();
        return arregloUsuarios(raiz,arreglo);
    }
    
    private ArrayList<Integer> arregloUsuarios(NodoUsuario n,ArrayList<Integer> arreglo){
        if(n !=null){
            arreglo = arregloUsuarios(n.getIzq(),arreglo);
            arreglo.add(n.getInformacion().getIdUsuario());
            arreglo = arregloUsuarios(n.getDer(),arreglo);
        }
        return arreglo;
    }
    
    //Metodo para validar si es hoja
    private boolean esHoja(NodoUsuario aux) {
        if (aux.getIzq() == null && aux.getDer() == null) {
            return true;
        }
        return false;
    }

    //Metodo para validar si tiene un hijo
    private boolean tieneUnHijo(NodoUsuario aux) {
        if ((aux.getIzq() == null && aux.getDer() != null) || (aux.getIzq() != null && aux.getDer() == null)) {
            return true;
        }
        return false;
    }

    //Metodo para eliminar hoja
    private void eliminarHoja(NodoUsuario aux) {
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
    private void eliminarUnHijo(NodoUsuario aux) {
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
    private void eliminarDosHijos(NodoUsuario aux) {
        NodoUsuario mayor = buscarMayor(aux.getIzq());
        aux.setInformacion(mayor.getInformacion());
        if(esHoja(mayor))
            eliminarHoja(mayor);
        else
            eliminarUnHijo(mayor);
    }
    
    //Metodo para buscar hijo mayor
    private NodoUsuario buscarMayor(NodoUsuario m){
        while(m.getDer()!=null)
            m = m.getDer();
        return m;
    }

    //Metodo para eliminar usuario
    public void eliminarUsuario(int info) {
        NodoUsuario aux = buscarUsuario(info);
        if (aux != null) {
            if (esHoja(aux)) {
                eliminarHoja(aux);
            } else if (tieneUnHijo(aux)) {
                eliminarUnHijo(aux);
            } else {
                eliminarDosHijos(aux);
            }
            tamano--;
            JOptionPane.showMessageDialog(null, "Usuario borrado");
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no se encuentra");
        }
    }
}
