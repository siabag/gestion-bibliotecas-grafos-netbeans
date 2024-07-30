package Biblioteca;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Grafo {

    //Se definen atributos
    private int nodos[];
    private int matrizRelacion[][];

    //Constructor
    public Grafo(int nodos) {
        this.nodos = new int[nodos];
        this.matrizRelacion = new int[nodos][nodos];
    }

    //Metodos get y set
    public int[] getNodos() {
        return nodos;
    }

    public void setNodos(int[] nodos) {
        this.nodos = nodos;
    }

    public int[][] getMatrizRelacion() {
        return matrizRelacion;
    }

    public void setMatrizRelacion(int[][] matrizRelacion) {
        this.matrizRelacion = matrizRelacion;
    }

    //Metodo para llenar array de nodos o vertices
    public int[] llenarNodos(GestorLibros arbolL, GestorUsuarios arbolU, int tama) {
        int[] arreglo = new int[tama];
        ArrayList<Integer> usuarios = arbolU.getUsuarios().arregloUsuarios();
        ArrayList<Integer> libros = arbolL.getLibros().arregloLibros();
        for (int i = 0; i < tama; i++) {
            if (i < usuarios.size()) {
                arreglo[i] = usuarios.get(i);
            } else {
                arreglo[i] = libros.get(i - usuarios.size());
            }
        }
        return arreglo;
    }

    //Metodo para llenar matriz de relacion
    public int[][] llenarMatrizRelacion(GestorPrestamos arbolP, GestorLibros arbolL, GestorUsuarios arbolU, int tama) {
        int[][] matriz = new int[tama][tama];
        int tamaPrestamo = arbolP.getPrestamos().getTamano();
        int usuario, libro;
        NodoPrestamo aux;
        ArrayList<Integer> prestamos = arbolP.getPrestamos().arregloPrestamos();
        ArrayList<Integer> usuarios = arbolU.getUsuarios().arregloUsuarios();
        ArrayList<Integer> libros = arbolL.getLibros().arregloLibros();
        for (int i = 0; i < tama; i++) {
            for (int j = 0; j < tama; j++) {
                matriz[i][j] = 0;
            }
        }
        for (int i : prestamos) {
            aux = arbolP.getPrestamos().buscarPrestamo(i);
            usuario = aux.getInformacion().getIdUsuarioPrestamo();
            libro = aux.getInformacion().getIdLibroPrestamo();
            matriz[usuarios.indexOf(usuario)][libros.indexOf(libro) + 3] += 1;
            matriz[libros.indexOf(libro) + 3][usuarios.indexOf(usuario)] += 1;
        }
        return matriz;
    }
    
    //Metodo para veces que el libro es prestado
    public void vecesPrestamoLibro(int id, int tama){
        int posicion = 0;
        int veces = 0;
        for (int i = 0; i < nodos.length; i++) {
            if(nodos.equals(id)){
                posicion = i;
            }
        }
        for (int i = 0; i < tama; i++) {
            veces += matrizRelacion[posicion][i];
        }
        JOptionPane.showMessageDialog(null, "La cantidad de veces que el libro con ID: "
                                                        +id+" ha sido prestado es "+veces);
    }
}
