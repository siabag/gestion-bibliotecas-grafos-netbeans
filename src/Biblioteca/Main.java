package Biblioteca;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        //Se crean objetos para la gestion de usuarios, libros y prestamos
        GestorUsuarios arbolUsuario = new GestorUsuarios();
        GestorLibros arbolLibro = new GestorLibros();
        GestorPrestamos arbolPrestamo = new GestorPrestamos();
        GestorGrafos grafo = new GestorGrafos();

        //Se definen variables
        int opcion = 0;

        //Se crean 3 usuarios para iniciar la lista
        arbolUsuario.getUsuarios().insertarUsuario(215, "Cesar", "Valencia", 2384576);
        arbolUsuario.getUsuarios().insertarUsuario(597, "Viviana", "Hurtado", 3873629);
        arbolUsuario.getUsuarios().insertarUsuario(326, "Isabel", "Valencia", 2748399);

        //Se crean 3 libros para iniciar la lista
        arbolLibro.getLibros().insertarLibro(10049, "Lestat El Vampiro", "Anne Rice");
        arbolLibro.getLibros().insertarLibro(10002, "Ensayo Sobre La Ceguera", "Jose Saramago");
        arbolLibro.getLibros().insertarLibro(10363, "Adulterio", "Pablo Coelho");

        //Se crean 15 prestamos para la creacion del grafo
        arbolPrestamo.getPrestamos().insertarPrestamo(549820, "12/03/2023", 215, 10049);
        arbolPrestamo.getPrestamos().insertarPrestamo(746329, "08/12/2022", 597, 10002);
        arbolPrestamo.getPrestamos().insertarPrestamo(387619, "22/03/2023", 215, 10049);
        arbolPrestamo.getPrestamos().insertarPrestamo(232347, "13/06/2023", 326, 10363);
        arbolPrestamo.getPrestamos().insertarPrestamo(968523, "24/07/2022", 597, 10002);
        arbolPrestamo.getPrestamos().insertarPrestamo(858483, "08/12/2022", 326, 10363);
        arbolPrestamo.getPrestamos().insertarPrestamo(204983, "12/03/2023", 215, 10002);
        arbolPrestamo.getPrestamos().insertarPrestamo(493723, "13/06/2023", 326, 10002);
        arbolPrestamo.getPrestamos().insertarPrestamo(885536, "22/03/2023", 597, 10049);
        arbolPrestamo.getPrestamos().insertarPrestamo(342234, "13/06/2023", 326, 10002);
        arbolPrestamo.getPrestamos().insertarPrestamo(909875, "08/12/2022", 215, 10002);
        arbolPrestamo.getPrestamos().insertarPrestamo(274832, "12/03/2023", 326, 10049);
        arbolPrestamo.getPrestamos().insertarPrestamo(453219, "22/03/2023", 597, 10002);
        arbolPrestamo.getPrestamos().insertarPrestamo(512320, "08/12/2022", 215, 10363);
        arbolPrestamo.getPrestamos().insertarPrestamo(764532, "12/03/2023", 597, 10363);

        //Se crea menu principal
        do {
            try {
                opcion = Integer.parseUnsignedInt(JOptionPane.showInputDialog(null,
                        "Menu principal\n\n"
                        + "1. Gestion de Usuarios\n"
                        + "2. Gestion de Libros\n"
                        + "3. Gestion de Prestamos\n"
                        + "4. Gestion de Grafos\n"
                        + "5. Salir"));
            } catch (NumberFormatException e) {
            }
            switch (opcion) {
                case 1:
                    arbolUsuario.menuGestionUsuarios(arbolUsuario);
                    break;
                case 2:
                    arbolLibro.menuGestionLibros(arbolLibro);
                    break;
                case 3:
                    arbolPrestamo.menuGestionPrestamos(arbolPrestamo, arbolLibro, arbolUsuario);
                    break;
                case 4:
                    grafo.menuGestionGrafos(arbolPrestamo, arbolLibro, arbolUsuario);
                    break;
                case 5:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta!!");
            }
        } while (opcion != 5);
    }
}
