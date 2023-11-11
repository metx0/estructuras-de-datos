public class NodoArbol <T> {
	private T dato;
	private boolean esBinario = false;
	private NodoArbol <T> primerHijo;
	private NodoArbol <T> siguienteHermano;

	// El nodo puede guardar cualquier tipo de dato
	public NodoArbol (T dato) {
		this.dato = dato;
		primerHijo = null;
		siguienteHermano = null;
	}

	public void agregarHijo (NodoArbol <T> hijo) {
		// Si no hay elementos, se le establece el primer hijo
		if (primerHijo == null) {
			primerHijo = hijo;
		} 
		// Si ya hay elementos
		else { 
			NodoArbol<T> hermano = this.primerHijo;

			if (esBinario) {
				if (hermano.siguienteHermano != null) {
					System.err.println("El nodo ya tiene un hijo, no se debe agregar " + hijo.getDato());	
				} else {
					hermano.siguienteHermano = hijo;
				}
			// Si no es binario, puede tener n hijos
			} else {
				// Obtenemos la referencia del último hijo
				while (hermano.siguienteHermano != null) {
					hermano = hermano.siguienteHermano;
				}
				hermano.siguienteHermano = hijo;
			}      
		}
	}

	public NodoArbol<T> obtenerPrimerHijo () {
		return primerHijo;
	}

	public NodoArbol<T> obtenerSiguienteHermano () {
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