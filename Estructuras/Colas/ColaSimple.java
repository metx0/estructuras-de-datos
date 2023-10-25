public class ColaSimple {
    // El frente es el único nodo al que se tiene acceso
    private Nodo frente;
    // El tamaño de la cola
    private int longitud;

    // Operaciones de la cola

    public void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (frente == null) {
            frente = nuevoNodo;
        } else {
            Nodo nodoActual = frente;
            // Recorremos la cola
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nuevoNodo);
        }
        
        longitud++;
    }

    public void eliminar() {
        if (estaVacia()) {
            System.out.println("No hay elementos en la cola");
            return;
        }

        frente = frente.getSiguiente();
        longitud--;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public Nodo getFrente() {
        // Si la cola está vacía
        if (frente == null) {
            System.out.println("No hay elementos en la cola");
            return null;
        }

        return frente;
    }

    public int getLongitud() {
        return longitud;
    }
}