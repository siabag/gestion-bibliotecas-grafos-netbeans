package Biblioteca;

import javax.swing.JOptionPane;

public class GestorGrafos {

    //Se definen atributos
    private Grafo grafo;

    //Constructor
    public GestorGrafos() {
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    //Metodo para gestionar prestamos
    public void menuGestionGrafos(GestorPrestamos arbolP, GestorLibros arbolL, GestorUsuarios arbolU) {
        int tama = arbolL.getLibros().getTamano() + arbolU.getUsuarios().getTamano();
        grafo = new Grafo(tama);
        grafo.setNodos(grafo.llenarNodos(arbolL, arbolU, tama));
        grafo.setMatrizRelacion(grafo.llenarMatrizRelacion(arbolP, arbolL, arbolU, tama));
        int opcion = 0;
        do {
            try {
                opcion = Integer.parseUnsignedInt(JOptionPane.showInputDialog(null,
                        "Menu Gestion Grafos\n\n"
                        + "1. Matriz de relacion usuarios y libros\n"
                        + "2. Cantidad de veces que se presta un libro\n"
                        + "3. Salir"));
            } catch (Exception e) {
            }
            switch (opcion) {
                case 1:
                    String texto = "Matriz de relacion\n\n| Nodos | ";
                    for (int i = 0; i < tama; i++) {
                        texto += (i+1) + " | ";
                    }
                    texto += "\n";
                    for (int i = 0; i < tama; i++) {
                        texto += "|      "+(i+1)+"      ";
                        for (int j = 0; j < tama; j++) {
                            texto += "| "+grafo.getMatrizRelacion()[i][j]+" ";
                        }
                        texto +="\n";
                    }
                    JOptionPane.showMessageDialog(null, texto);
                    break;
                case 2:
                    int id = 0;
                    id = Integer.parseUnsignedInt(JOptionPane.showInputDialog(null,
                            "Ingresar el ID del Libro a consultar"));
                    grafo.vecesPrestamoLibro(id,tama);
                    break;
                case 3:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta!!");
            }
        } while (opcion != 3);
    }

}
