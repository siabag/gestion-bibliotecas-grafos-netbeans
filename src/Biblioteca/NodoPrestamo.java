package Biblioteca;

public class NodoPrestamo {

    //Se definen atributos
    private Prestamo informacion;
    private NodoPrestamo izq;
    private NodoPrestamo der;
    private NodoPrestamo padre;

    //Constructor
    public NodoPrestamo(Prestamo informacion) {
        this.informacion = informacion;
        this.izq = null;
        this.der = null;
        this.padre = null;
    }

    public NodoPrestamo(Prestamo informacion, NodoPrestamo izq, NodoPrestamo der, NodoPrestamo padre) {
        this.informacion = informacion;
        this.izq = izq;
        this.der = der;
        this.padre = padre;
    }

    public NodoPrestamo(Prestamo informacion, NodoPrestamo padre) {
        this.informacion = informacion;
        this.izq = null;
        this.der = null;
        this.padre = padre;
    }

    //Metodos accesores
    public Prestamo getInformacion() {
        return informacion;
    }

    public void setInformacion(Prestamo informacion) {
        this.informacion = informacion;
    }

    public NodoPrestamo getIzq() {
        return izq;
    }

    public void setIzq(NodoPrestamo izq) {
        this.izq = izq;
    }

    public NodoPrestamo getDer() {
        return der;
    }

    public void setDer(NodoPrestamo der) {
        this.der = der;
    }

    public NodoPrestamo getPadre() {
        return padre;
    }

    public void setPadre(NodoPrestamo padre) {
        this.padre = padre;
    }

}
