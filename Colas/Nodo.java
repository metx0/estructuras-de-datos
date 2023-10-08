public class Nodo {
    // El dato que contiene el nodo
    private int dato;
    // La referencia al siguiente nodo
    private Nodo siguiente;

    // Pasamos el dato que contiene el nodo en el constructor
    public Nodo(int dato) {
        this.dato = dato;
    }

    // Getters y setters

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}