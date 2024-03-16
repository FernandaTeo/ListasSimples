package umg.edu.progra.listas;

public class Principal {

    public static void main(String[] args) {

        Lista lista = new Lista();
        lista.insertarCabezaLista(1);
        lista.insertarCabezaLista(2);
        lista.insertarCabezaLista(3);
        lista.insertarCabezaLista(4);
        lista.insertarCabezaLista(5);
        lista.insertarCabezaLista(6);

        lista.visualizar();

        System.out.println("\n");

        // Llamar a los métodos adicionales

        // Invertir la lista
        System.out.println("Invertir lista:");
        lista.invertirLista();
        lista.visualizar();

        // Obtener elemento de la posición n desde el final de la lista
        int posicionDesdeFinal = 2; // Por ejemplo, obtener el segundo elemento desde el final
        int valor = lista.obtenerDesdeElFinal(posicionDesdeFinal);
        System.out.println("\nElemento en la posición " + posicionDesdeFinal + " desde el final: " + valor);

        // Eliminar duplicados en la lista
        System.out.println("\nEliminar duplicados:");
        lista.eliminarDuplicados();
        lista.visualizar();

        // Obtener tamaño de la lista
        int tamaño = lista.obtenerTamaño();
        System.out.println("\nTamaño de la lista: " + tamaño);
    }
}
