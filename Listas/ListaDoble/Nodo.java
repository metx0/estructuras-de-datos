public class Nodo {
    // El dato que contiene el nodo
    private int dato;
    // La referencia al nodo siguiente
    private Nodo siguiente;
    // La referencia al nodo anterior
    private Nodo anterior;

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

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}