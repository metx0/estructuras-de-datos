public class Nodo {
	int dato;
	private int altura;
	Nodo izquierdo, derecho;

	public Nodo(int dato) {
		this.dato = dato;
		// Cuando es insertado, un nodo tiene altura 1 
		altura = 1;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getAltura() {
		return altura;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public int getDato() {
		return dato;
	}
}