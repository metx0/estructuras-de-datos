/* 
Autor: Miguel Alejandro Torruco
Fecha: 09/09/23
*/

public class Nodo {
    // El dato que guarda el nodo
    private int dato;
    // La referencia al nodo siguiente del nodo actual 
    private Nodo siguiente;

    // Constructor de la clase. El nodo se crea con un dato entero
    // "siguiente" se inicializa como null por defecto
    public Nodo(int dato) {
        this.dato = dato;
    }

    // Setters y getters

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public int getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }
}