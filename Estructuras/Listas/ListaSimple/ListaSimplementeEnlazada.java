public class ListaSimplementeEnlazada {
    // El primer nodo de la lista
    private Nodo frente;
    // El tamaño de la lista
    private int longitud;

    // Operaciones de la lista

    public void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (frente == null) {
            frente = nuevoNodo;
        } else {
            Nodo nodoActual = frente;
            // Recorremos la lista
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nuevoNodo);
        }
        
        longitud++;
    }

    public int obtener(int indice) {
        if (indice < 0 || indice >= longitud) {
            System.err.println("Indice fuera de rango");
            return -1;
        }

        Nodo nodoActual = frente;

        for (int i = 0; i < indice; i++) {
            nodoActual = nodoActual.getSiguiente();
        }

        return nodoActual.getDato();
    }

    public void eliminar(int indice) {
        if (estaVacia()) {
            System.out.println("No hay elementos en la lista");
            return;
        }

        if (indice < 0 || indice >= longitud) {
            System.err.println("Indice fuera de rango");
            return;
        }

        // Si el nodo a eliminar es el primer nodo
        if (indice == 0) {
            frente = frente.getSiguiente();
        } else { // Si es un nodo diferente al primero
            Nodo nodoAnterior = frente;

            for (int i = 0; i < indice - 1; i++) {
                nodoAnterior = nodoAnterior.getSiguiente();
            }

            Nodo nodoAEliminar = nodoAnterior.getSiguiente();
            nodoAnterior.setSiguiente(nodoAEliminar.getSiguiente());
        }

        longitud--;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int getLongitud() {
        return longitud;
    }
}