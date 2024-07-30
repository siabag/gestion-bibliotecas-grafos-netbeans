package Biblioteca;

public class NodoLibro {

    //Se definen atributos
    private Libro informacion;
    private NodoLibro izq;
    private NodoLibro der;
    private NodoLibro padre;

    //Constructor
    public NodoLibro(Libro informacion) {
        this.informacion = informacion;
        this.izq = null;
        this.der = null;
        this.padre = null;
    }

    public NodoLibro(Libro informacion, NodoLibro izq, NodoLibro der, NodoLibro padre) {
        this.informacion = informacion;
        this.izq = izq;
        this.der = der;
        this.padre = padre;
    }

    public NodoLibro(Libro informacion, NodoLibro padre) {
        this.informacion = informacion;
        this.izq = null;
        this.der = null;
        this.padre = padre;
    }

    //Metodos accesores
    public Libro getInformacion() {
        return informacion;
    }

    public void setInformacion(Libro informacion) {
        this.informacion = informacion;
    }

    public NodoLibro getIzq() {
        return izq;
    }

    public void setIzq(NodoLibro izq) {
        this.izq = izq;
    }

    public NodoLibro getDer() {
        return der;
    }

    public void setDer(NodoLibro der) {
        this.der = der;
    }

    public NodoLibro getPadre() {
        return padre;
    }

    public void setPadre(NodoLibro padre) {
        this.padre = padre;
    }

}
