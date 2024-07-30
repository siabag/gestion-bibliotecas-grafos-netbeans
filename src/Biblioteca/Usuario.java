package Biblioteca;

public class Usuario {

    //Se definen atributos
    private int idUsuario;
    private String nombreUsuario;
    private String apellidoUsuuario;
    private int telefonoUsuario;

    //Constructor
    public Usuario(int idUsuario, String nombreUsuario, String apellidoUsuuario, int telefonoUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuuario = apellidoUsuuario;
        this.telefonoUsuario = telefonoUsuario;
    }

    //Metodos accesores
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuuario() {
        return apellidoUsuuario;
    }

    public void setApellidoUsuuario(String apellidoUsuuario) {
        this.apellidoUsuuario = apellidoUsuuario;
    }

    public int getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(int telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

}
