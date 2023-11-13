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
	* @param esBinario Si es binario o no
	*/
	public Arbol (T dato, boolean esBinario) {
		raiz = new NodoArbol <T> (dato);
		raiz.setEsBinario(esBinario);
		this.esBinario = esBinario;
	}
	
	public NodoArbol <T> getRaiz() {
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

	/**
	* Obtiene la altura del árbol, la cual es la cantidad de nodos que hay desde la raíz hasta
	* el nodo más inferior
	*
	* @param nodo El nodo a partir del cual quieres sacar la altura
	*/
	public int obtenerAltura(NodoArbol nodo) {
		if (nodo == null) {
			return 0;
		}

		int alturaIzquierda = obtenerAltura(nodo.getPrimerHijo());
		int alturaDerecha;

		if (nodo.getPrimerHijo() == null) {
			alturaDerecha = 0;
		} else {
			alturaDerecha = obtenerAltura(nodo.getPrimerHijo().getSiguienteHermano());
		}

		if (alturaIzquierda > alturaDerecha) {
			return alturaIzquierda + 1;
		}
		else {
			return alturaDerecha + 1;
		}

	}

	/**
	* Se imprime el subárbol que tiene como raíz el nodo "nodo", en el tipo de recorrido indicado
	*
	* @param nodo El nodo el cual es la raíz del subárbol que quieres imprimir
	* @param recorrido Puede ser prefijo, infijo o posfijo. Debe pertenecer al enum Recorrido
	*/
	public void imprimirSubArbol(NodoArbol <T> nodo, Recorrido recorrido) {
		switch (recorrido.ordinal()) {
		case 0:
			System.out.println("Prefijo: ");
			nodo.imprimirEnPrefijo();
			break;
	
		case 1:
			System.out.println("\nInfijo: ");
			nodo.imprimirEnInfijo();
			break;
	
		case 2:
			System.out.println("\nPosfijo: ");
			nodo.imprimirEnPosfijo();
			break;
		
		default:
			break;
		}
	}
	
	/**
	* Se imprime el árbol en cuestión, empezando desde el nodo "raiz", en el tipo de recorrido indicado
	*
	* @param recorrido Puede ser prefijo, infijo o posfijo. Debe pertenecer al enum Recorrido
	*/
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