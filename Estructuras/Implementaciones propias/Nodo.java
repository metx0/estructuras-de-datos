// Un nodo es un elemento de una estructura de datos
// Es útil porque contiene el dato a guardar y la referencia de otro nodo

public class Nodo {
    private int dato;
    // La referencia al nodo siguiente
    private Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
    }

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