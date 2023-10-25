public class ColaCircular {
    private Nodo frente;
    private Nodo atras;
    private int longitud;

    public void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (estaVacia()) {
            frente = nuevoNodo;
            atras = nuevoNodo;
            atras.setSiguiente(frente);
        } else { 
            atras.setSiguiente(nuevoNodo);
            atras = nuevoNodo;
            atras.setSiguiente(frente);
        }

        longitud++;
    }

    public void eliminar() {
        if (estaVacia()) {
            System.out.println("No hay elementos en la cola");
            return;
        }

        // El código siguiente se ejecuta si la cola no está vacía

        if (frente == atras) {
            frente = null;
            atras = null;
        } else {
            frente = frente.getSiguiente();
            atras.setSiguiente(frente);
        }

        longitud--;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public Nodo getFrente() {
        if (frente == null) {
            System.out.println("No hay elementos en la cola");
            return null;
        }
        
        // Si es distinto de nulo, se ejecuta lo siguiente
        return frente;
    }

    public Nodo getAtras() {
        if (atras == null) {
            System.out.println("No hay elementos en la cola");
            return null;
        }
        
        // Si es distinto de nulo, se ejecuta lo siguiente
        return atras;
    }

    public int getLongitud() {
        return longitud;
    }
}