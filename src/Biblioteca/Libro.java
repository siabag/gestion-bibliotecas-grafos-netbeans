package Biblioteca;

public class Libro {

    //Se definen atributos
    private int idLibro;
    private String nombreLibro;
    private String autorLibro;
    private int enPrestamo;

    //Constructor
    public Libro(int idLibro, String nombreLibro, String autorLibro) {
        this.idLibro = idLibro;
        this.nombreLibro = nombreLibro;
        this.autorLibro = autorLibro;
        enPrestamo = 0;
    }

    //Metodos accesores
    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }

    public int getEnPrestamo() {
        return enPrestamo;
    }

    public void setEnPrestamo(int enPrestamo) {
        this.enPrestamo = enPrestamo;
    }

}
