/*
Un nodo de un árbol binario
Los nodos de un árbol binario tienen como máximo dos hijos: el izquierdo y el derecho
*/

public class Nodo {
	int dato;
	Nodo izquierdo, derecho;

	public Nodo(int dato) {
		this.dato = dato;
	}

	// Por si izquierdo y derecho se hacen privados después

	public void setIzquierdo(int dato) {
		this.izquierdo = new Nodo(dato);
	}

	public void setDerecho(int dato) {
		this.derecho = new Nodo(dato);
	}

	public int getDato() {
		return dato;
	}
}