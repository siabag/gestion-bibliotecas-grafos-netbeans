package Biblioteca;

public class Prestamo {

    //Se definen atributos
    private int idPrestamo;
    private String fechaPrestamo;
    private int idUsuarioPrestamo;
    private int idLibroPrestamo;

    //Constructor
    public Prestamo(int idPrestamo, String fechaPrestamo, int idUsuarioPrestamo, int idLibroPrestamo) {
        this.idPrestamo = idPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.idUsuarioPrestamo = idUsuarioPrestamo;
        this.idLibroPrestamo = idLibroPrestamo;
    }

    //Metodos accesores
    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public int getIdUsuarioPrestamo() {
        return idUsuarioPrestamo;
    }

    public void setIdUsuarioPrestamo(int idUsuarioPrestamo) {
        this.idUsuarioPrestamo = idUsuarioPrestamo;
    }

    public int getIdLibroPrestamo() {
        return idLibroPrestamo;
    }

    public void setIdLibroPrestamo(int idLibroPrestamo) {
        this.idLibroPrestamo = idLibroPrestamo;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

}
