package Biblioteca;

import javax.swing.JOptionPane;

public class GestorLibros {

    //Se definen atributos
    private ArbolLibros libros;

    //Constructor
    public GestorLibros() {
        libros = new ArbolLibros();
    }

    //Metodos accesores
    public ArbolLibros getLibros() {
        return libros;
    }

    public void setLibros(ArbolLibros libros) {
        this.libros = libros;
    }

    //Metodo para gestionar libros
    public void menuGestionLibros(GestorLibros arbol) {
        int opcion = 0;
        int id;
        String nombre, autor;
        do {
            try {
                opcion = Integer.parseUnsignedInt(JOptionPane.showInputDialog(null,
                        "Menu Gestion Libros\n\n"
                        + "1. Insertar Libro\n"
                        + "2. Eliminar Libro\n"
                        + "3. Consultar Libro\n"
                        + "4. Listar Libros\n"
                        + "5. Salir"));
            } catch (NumberFormatException e) {
            }
            switch (opcion) {
                case 1:
                    id = 0;
                    nombre = "";
                    autor ="";
                    id = Integer.parseUnsignedInt(JOptionPane.showInputDialog(null,
                            "Ingresar el ID del Libro"));
                    nombre = JOptionPane.showInputDialog(null,
                            "Ingresar el Nombre del Libro");
                    autor = JOptionPane.showInputDialog(null,
                            "Ingresar el Autor del Libro");
                    arbol.getLibros().insertarLibro(id, nombre, autor);
                    break;
                case 2:
                    id = 0;
                    id = Integer.parseUnsignedInt(JOptionPane.showInputDialog(null,
                            "Ingresar el ID del Libro a borrar"));
                    arbol.getLibros().eliminarLibro(id);
                    break;
                case 3:
                    id = 0;
                    id = Integer.parseUnsignedInt(JOptionPane.showInputDialog(null,
                            "Ingresar el ID del Libro que desea consultar"));
                    arbol.getLibros().mostrarLibro(id);
                    break;
                case 4:
                    arbol.getLibros().listarLibros();
                    break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta!!");
            }
        } while (opcion != 5);
    }
}
