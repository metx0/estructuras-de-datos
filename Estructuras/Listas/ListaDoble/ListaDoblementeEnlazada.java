public class ListaDoblementeEnlazada {
    private Nodo primerNodo;
    private Nodo ultimoNodo;
    private int longitud;

    public void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (primerNodo == null) {
            primerNodo = nuevoNodo;
            ultimoNodo = nuevoNodo; // Si la lista está vacía, el último nodo es el primero
        } else {
            nuevoNodo.setAnterior(ultimoNodo); // El nodo anterior al nuevo nodo es el último nodo
            ultimoNodo.setSiguiente(nuevoNodo); // El siguiente del último nodo es el nuevo nodo
            ultimoNodo = nuevoNodo; // El nuevo nodo se convierte en el último nodo
        }

        longitud++;
    }

    public int obtener(int indice) {
        if (indice < 0 || indice >= longitud) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Nodo nodoActual;

        if (indice == 0) {
            return primerNodo.getDato();
        } else if (indice == longitud - 1) {
            return ultimoNodo.getDato();
        } else {
            if (indice < longitud / 2) {
                nodoActual = primerNodo;

                for (int i = 0; i < indice; i++) {
                    nodoActual = nodoActual.getSiguiente();
                }

                return nodoActual.getDato();
            } else {
                nodoActual = ultimoNodo;

                for (int i = longitud - 1; i > indice; i--) {
                    nodoActual = nodoActual.getAnterior();
                }

                return nodoActual.getDato();
            }
        }
    }

    public void eliminar(int indice) {
        if (indice < 0 || indice >= longitud) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Nodo nodoAEliminar;

        // Si queremos eliminar el primer elemento
        if (indice == 0) {
            nodoAEliminar = primerNodo;
            primerNodo = primerNodo.getSiguiente();
        } else if (indice == longitud - 1) { // Si es el último elemento
            nodoAEliminar = ultimoNodo;
            ultimoNodo = ultimoNodo.getAnterior();
            ultimoNodo.setSiguiente(null);
        } else {
            Nodo nodoActual;
            if (indice < longitud / 2) {
                nodoActual = primerNodo;

                for (int i = 0; i < indice; i++) {
                    nodoActual = nodoActual.getSiguiente();
                }
            } else {
                nodoActual = ultimoNodo;

                for (int i = longitud - 1; i > indice; i--) {
                    nodoActual = nodoActual.getAnterior();
                }
            }

            nodoAEliminar = nodoActual;
            nodoActual.getAnterior().setSiguiente(nodoActual.getSiguiente());
            nodoActual.getSiguiente().setAnterior(nodoActual.getAnterior());
        }

        nodoAEliminar.setAnterior(null);
        nodoAEliminar.setSiguiente(null);
        longitud--;
    }

    public int longitud() {
        return longitud;
    }
}