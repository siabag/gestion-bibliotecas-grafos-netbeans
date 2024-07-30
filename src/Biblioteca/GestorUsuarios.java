
package Biblioteca;

import javax.swing.JOptionPane;

public class GestorUsuarios {
    
    //Se definen atributos
    
    private ArbolUsuario usuarios;
    
    //Constructor

    public GestorUsuarios() {
        usuarios = new ArbolUsuario();
    }
    
    //Metodos accesores

    public ArbolUsuario getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArbolUsuario usuarios) {
        this.usuarios = usuarios;
    }
    
    //Metodo para gestionar usuarios
    public void menuGestionUsuarios(GestorUsuarios arbol) {
        int opcion = 0;
        int id,telefono;
        String nombre, apellido;
        do {
            try {
                opcion = Integer.parseUnsignedInt(JOptionPane.showInputDialog(null,
                        "Menu Gestion Usuarios\n\n"
                        + "1. Insertar Usuario\n"
                        + "2. Eliminar Usuario\n"
                        + "3. Consultar Usuario\n"
                        + "4. Listar Usuario\n"
                        + "5. Salir"));
            } catch (NumberFormatException e) {
            }
            switch (opcion) {
                case 1:
                    id = 0;
                    nombre = "";
                    apellido ="";
                    telefono = 0;
                    id = Integer.parseUnsignedInt(JOptionPane.showInputDialog(null,
                            "Ingresar el ID del Usuario"));
                    nombre = JOptionPane.showInputDialog(null,
                            "Ingresar el Nombre del Usuario");
                    apellido = JOptionPane.showInputDialog(null,
                            "Ingresar el apellido del Usuario");
                    telefono = Integer.parseUnsignedInt(JOptionPane.showInputDialog(null,
                            "Ingresar el Telefono del Usuario"));
                    arbol.getUsuarios().insertarUsuario(id, nombre, apellido, telefono);
                    break;
                case 2:
                    id = 0;
                    id = Integer.parseUnsignedInt(JOptionPane.showInputDialog(null,
                            "Ingresar el ID del Usuario a borrar"));
                    arbol.getUsuarios().eliminarUsuario(id);
                    break;
                case 3:
                    id = 0;
                    id = Integer.parseUnsignedInt(JOptionPane.showInputDialog(null,
                            "Ingresar el ID del Usuario que desea consultar"));
                    arbol.getUsuarios().mostrarUsuario(id);
                    break;
                case 4:
                    arbol.getUsuarios().listarUsuarios();
                    break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta!!");
            }
        } while (opcion != 5);
    }
}
