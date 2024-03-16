package umg.edu.progra.listas;

import java.util.HashSet;
import java.util.Set;

/**
 * Clase que representa una lista enlazada.
 *
 * @author Walter Cordova
 */
public class Lista {

    private Nodo primero;

    /**
     * Devuelve una representación en cadena de la lista.
     *
     * @return Representación en cadena de la lista.
     */
    @Override
    public String toString() {
        return "=>" + primero;
    }

    /**
     * Constructor para inicializar una lista vacía.
     */
    public Lista() {
        primero = null;
    }

    /**
     * Devuelve el primer nodo de la lista.
     *
     * @return Primer nodo de la lista.
     */
    public Nodo leerPrimero() {
        return primero;
    }

    /**
     * Inserta un nuevo nodo al principio de la lista con el valor dado.
     *
     * @param entrada Valor a insertar.
     */
    public void insertarCabezaLista(int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = primero;
        primero = nuevo;
    }

    /**
     * Inserta un nuevo nodo después del nodo anterior con el valor dado.
     *
     * @param anterior Nodo anterior al nuevo nodo.
     * @param entrada  Valor a insertar.
     */
    public void insertarLista(Nodo anterior, int entrada) {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = anterior.enlace;
        anterior.enlace = nuevo;
    }

    /**
     * Elimina el nodo que contiene el valor dado de la lista.
     *
     * @param entrada Valor a eliminar.
     */
    public void eliminar(int entrada) {
        Nodo actual, anterior;
        actual = primero;
        anterior = null;
        // Bucle de búsqueda
        while ((actual != null) && !(actual.dato == entrada)) {
            anterior = actual;
            actual = actual.enlace;
        }
        if (actual != null) {
            // Se distingue entre que el nodo sea el cabecera
            // o del resto de la lista
            if (actual == primero) {
                primero = actual.enlace;
            } else {
                anterior.enlace = actual.enlace;
            }
        }
    }

    /**
     * Busca el nodo que contiene el valor dado en la lista.
     *
     * @param destino Valor a buscar.
     * @return Nodo que contiene el valor, o null si no se encuentra.
     */
    public Nodo buscarLista(int destino) {
        Nodo indice;
        for (indice = primero; indice != null; indice = indice.enlace) {
            if (indice.dato == destino) {
                return indice;
            }
        }
        return null;
    }

    /**
     * Recorre la lista y muestra cada dato.
     */
    public void visualizar() {
        Nodo n;
        n = primero;
        while (n != null) {
            System.out.print(n.dato + " ");
            n = n.enlace;
        }
    }

    // Tareas adicionales:

    /**
     * Invierte la lista enlazada.
     */
    public void invertirLista() {
        Nodo actual = primero;
        Nodo anterior = null;
        Nodo siguiente = null;

        while (actual != null) {
            siguiente = actual.enlace;
            actual.enlace = anterior;
            anterior = actual;
            actual = siguiente;
        }

        primero = anterior;
    }

    /**
     * Obtiene el elemento de la posición n desde el final de la lista.
     *
     * @param posicion Posición desde el final.
     * @return Valor del nodo en la posición especificada.
     */
    public int obtenerDesdeElFinal(int posicion) {
        int tamaño = obtenerTamaño();
        int posiciónDesdeInicio = tamaño - posicion - 1;
        Nodo actual = primero;

        // Ajuste para manejar el caso donde la posición es mayor que el tamaño de la lista
        if (posiciónDesdeInicio < 0) {
            return -1; // Indica que la posición está fuera de rango
        }

        for (int i = 0; i < posiciónDesdeInicio; i++) {
            actual = actual.enlace;
        }

        return actual.dato;
    }

    /**
     * Elimina los nodos duplicados en la lista enlazada.
     */
    public void eliminarDuplicados() {
        Set<Integer> valores = new HashSet<>();
        Nodo actual = primero;
        Nodo anterior = null;

        while (actual != null) {
            if (valores.contains(actual.dato)) {
                // Eliminar el nodo duplicado
                anterior.enlace = actual.enlace;
            } else {
                valores.add(actual.dato);
                anterior = actual;
            }
            actual = actual.enlace;
        }
    }

    /**
     * Obtiene el tamaño de la lista enlazada.
     *
     * @return Tamaño de la lista.
     */
    public int obtenerTamaño() {
        int tamaño = 0;
        Nodo actual = primero;

        while (actual != null) {
            tamaño++;
            actual = actual.enlace;
        }

        return tamaño;
    }
}
