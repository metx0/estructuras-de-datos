public class NodoArbol <T> {
	private T dato;
	private boolean esBinario = false;
	private NodoArbol <T> primerHijo;
	private NodoArbol <T> siguienteHermano;
	private int cantidadHijos = 0;

	// El nodo puede guardar cualquier tipo de dato
	public NodoArbol (T dato) {
		this.dato = dato;
		primerHijo = null;
		siguienteHermano = null;
	}

	/**
	* Añadir un hijo al nodo, en una estructura tipo lista enlazada
	* Se hacen validaciones para ver si es binario, si no tiene elementos, etc
	* Se incrementa el contador de hijos, en caso de éxito
	*
	* @param hijo El nodo a agregar como hijo al nodo actual
	*/
	public void agregarHijo (NodoArbol <T> hijo) {
		// Si no hay elementos, se le establece el primer hijo
		if (primerHijo == null) {
			primerHijo = hijo;
			cantidadHijos++;
			return;
		} 

		// Si ya hay elementos
		NodoArbol<T> hermano = this.primerHijo;

		if (esBinario) {
			if (hermano.siguienteHermano != null) {
				System.err.println("Es un árbol binario: el nodo ya tiene un hijo, no se debe agregar " + hijo.getDato());	
				return;
			} 
			hermano.siguienteHermano = hijo;
		// Si no es binario, puede tener n hijos
		} else {
			// Obtenemos la referencia del último hijo
			while (hermano.siguienteHermano != null) {
				hermano = hermano.siguienteHermano;
			}
			hermano.siguienteHermano = hijo;
		}      
		
		cantidadHijos++;
	}

	/**
	* Obtener el hijo número "numeroHijo" de un nodo
	*
	* @param numeroHijo El número de hijo que quieres recuperar de un nodo, empezando por el hijo
	* más a la izquierda y desde 1. Valores válidos: 1 <= numeroHijo <= cantidadHijos
	*/
	public NodoArbol<T> obtenerEnesimoHijo(int numeroHijo) {
		// Validar que sea entre 1 y el número de hijos del nodo
		if (numeroHijo < 1 || numeroHijo > cantidadHijos) {
			System.out.println("Valor incorrecto del número de hijo");
			return null;
		}

		NodoArbol enesimo = primerHijo;
		for (int i = 1; i < numeroHijo; i++) {
			enesimo = enesimo.siguienteHermano;
		}

		return enesimo;
	}

	public NodoArbol<T> getPrimerHijo () {
		return primerHijo;
	}

	public NodoArbol<T> getSiguienteHermano () {
		return siguienteHermano;
	}

	public T getDato () {
		return dato;
	}

	public boolean esBinario () {
		return esBinario;
	}

	public void setEsBinario (boolean esBinario) {
		this.esBinario = esBinario;
	}

	public void imprimirEnPrefijo() {
		System.out.print(dato + "\t");
		NodoArbol<T> hijo = primerHijo;

		while (hijo != null) {
			hijo.imprimirEnPrefijo();
			hijo = hijo.siguienteHermano;
		}
	}

	public void imprimirEnInfijo() {
		NodoArbol<T> hijo = primerHijo;

		if (hijo != null) {
			hijo.imprimirEnInfijo();
		}

		System.out.print(dato + "\t");
		while (hijo != null) {
			hijo = hijo.siguienteHermano;
			if (hijo != null) {
				hijo.imprimirEnInfijo();
			}
		}
	}

	public void imprimirEnPosfijo() {
		NodoArbol<T> hijo = primerHijo;

		while (hijo != null) {
			hijo.imprimirEnPosfijo();
			hijo = hijo.siguienteHermano;
		}

		System.out.print(dato + "\t");
	}
}