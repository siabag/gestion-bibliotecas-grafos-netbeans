package Biblioteca;

import javax.swing.JOptionPane;

public class GestorPrestamos {

    //Se definen atributos
    private ArbolPrestamo prestamos;

    //Constructor
    public GestorPrestamos() {
        prestamos = new ArbolPrestamo();
    }

    //Metodos accesores
    public ArbolPrestamo getPrestamos() {
        return prestamos;
    }
    
    public void setPrestamos(ArbolPrestamo prestamos) {
        this.prestamos = prestamos;
    }

    //Metodo para gestionar prestamos
    public void menuGestionPrestamos(GestorPrestamos arbolP, GestorLibros arbolL, GestorUsuarios arbolU) {
        int opcion = 0;
        int idP, idU, idL;
        String fecha;
        
        do {
            try {
                opcion = Integer.parseUnsignedInt(JOptionPane.showInputDialog(null,
                        "Menu Gestion Prestamos\n\n"
                        + "1. Insertar Prestamo\n"
                        + "2. Eliminar Prestamo\n"
                        + "3. Consultar Prestamo\n"
                        + "4. Listar Prestamo\n"
                        + "5. Salir"));
            } catch (NumberFormatException e) {
            }
            switch (opcion) {
                case 1:
                    idP = 0;
                    idU = 0;
                    idL = 0;
                    fecha = "";
                    idP = Integer.parseUnsignedInt(JOptionPane.showInputDialog(null,
                            "Ingresar el ID del Prestamo"));
                    fecha = JOptionPane.showInputDialog(null,
                            "Ingresar la fecha del Prestamo");
                    idU = Integer.parseUnsignedInt(JOptionPane.showInputDialog(null,
                            "Ingresar el ID del Usuario que realiza el prestamo"));
                    idL = Integer.parseUnsignedInt(JOptionPane.showInputDialog(null,
                            "Ingresar el ID del Libro prestado"));
                    if (arbolU.getUsuarios().validarUsuario(idU) && arbolL.getLibros().validarLibro(idL)) {
                        arbolP.getPrestamos().insertarPrestamo(idP, fecha, idU, idL);
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Datos incorrectos");
                    break;
                case 2:
                    idP = 0;
                    idP = Integer.parseUnsignedInt(JOptionPane.showInputDialog(null,
                            "Ingresar el ID del Prestamo a borrar"));
                    arbolP.getPrestamos().eliminarPrestamo(idP);
                    break;
                case 3:
                    idP = 0;
                    idP = Integer.parseUnsignedInt(JOptionPane.showInputDialog(null,
                            "Ingresar el ID del Prestamo que desea consultar"));
                    arbolP.getPrestamos().mostrarPrestamo(idP);
                    break;
                case 4:
                    arbolP.getPrestamos().listarPrestamos();
                    break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta!!");
            }
        } while (opcion != 5);
    }
}
