package Biblioteca;

public class NodoUsuario {

    //Se definen atributos
    private Usuario informacion;
    private NodoUsuario izq;
    private NodoUsuario der;
    private NodoUsuario padre;

    //Constructor
    public NodoUsuario(Usuario informacion) {
        this.informacion = informacion;
        this.izq = null;
        this.der = null;
        this.padre = null;
    }

    public NodoUsuario(Usuario informacion, NodoUsuario izq, NodoUsuario der, NodoUsuario padre) {
        this.informacion = informacion;
        this.izq = izq;
        this.der = der;
        this.padre = padre;
    }

    public NodoUsuario(Usuario informacion, NodoUsuario padre) {
        this.informacion = informacion;
        this.izq = null;
        this.der = null;
        this.padre = padre;
    }

    //Metodos accesores
    public Usuario getInformacion() {
        return informacion;
    }

    public void setInformacion(Usuario informacion) {
        this.informacion = informacion;
    }

    public NodoUsuario getIzq() {
        return izq;
    }

    public void setIzq(NodoUsuario izq) {
        this.izq = izq;
    }

    public NodoUsuario getDer() {
        return der;
    }

    public void setDer(NodoUsuario der) {
        this.der = der;
    }

    public NodoUsuario getPadre() {
        return padre;
    }

    public void setPadre(NodoUsuario padre) {
        this.padre = padre;
    }

}
