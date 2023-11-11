public class Arbol <T> {
	private NodoArbol <T> raiz;
    /* Un árbol puede ser binario (tener por lo menos 2 hijos) o
    ser genérico (n hijos) */
	private boolean esBinario = false;
	
	/**
	* Se crea un objeto árbol con la raíz conteniendo a dato
	* Si el árbol es binario, la raíz también debe ser binaria
	*
	* @param dato El dato que debe contener la raíz
	*/
	public Arbol (T dato, boolean esBinario) {
		raiz = new NodoArbol <T> (dato);
		raiz.setEsBinario(esBinario);
		this.esBinario = esBinario;
	}
	
	public NodoArbol <T> obtenerRaiz() {
		return raiz;
	}

	/**
	* Se le agrega un hijo a nodoRaiz; el hijo se llama nodoAgregado
	* Si quieres agregar hijos a la raíz, tienes que obtener la raíz del árbol y llamar al método 
	* Si quieres añadir k hijos a nodoN, llamarías a este método k veces con nodoN
	* en el primer parámetro y nodo_i en el segundo, donde i va desde 0 hasta k
	*
	* @param nodoRaiz El nodo padre, al que le quieres agregar el hijo
	* @param nodoAgregado El nodo que quieres añadir como hijo a "nodoRaiz"
	*/

	public void agregarNodoArbol(NodoArbol <T> nodoRaiz, NodoArbol <T> nodoAgregado) {
		if (esBinario) {
			nodoAgregado.setEsBinario(esBinario);
		}
		
		nodoRaiz.agregarHijo(nodoAgregado);
	}

	public boolean esBinario() {
		return esBinario;
	}

	public boolean estaVacio() {
		return raiz == null;
	}

	public int obtenerAltura() {
		return 0;
	}

	// Recibe un nodo del árbol e imprime su correspondiente subárbol
	public void imprimirSubArbol(NodoArbol <T> nodo) {

	}
	
	public void imprimirArbol(Recorrido recorrido) {
		switch (recorrido.ordinal()) {
		case 0:
			System.out.println("Prefijo: ");
			raiz.imprimirEnPrefijo();
			break;
	
		case 1:
			System.out.println("\nInfijo: ");
			raiz.imprimirEnInfijo();
			break;
	
		case 2:
			System.out.println("\nPosfijo: ");
			raiz.imprimirEnPosfijo();
			break;
		
		default:
			break;
		}
	}
}