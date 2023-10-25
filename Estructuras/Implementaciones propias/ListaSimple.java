import java.util.NoSuchElementException;

/**
 * Esta clase representa una lista enlazada
 * Métodos implementados:
 * -insertar(dato): inserta el dato al final de la lista
 * -insertar(dato, indice): inserta el dato en el índice especificado
 * -eliminar(indice): elimina el nodo del índice especificado
 * -eliminarPorDato(valor: elimina la primer ocurrencia del nodo con dicho valor
 * -obtenerDatoEn(indice): te retorna el dato que contiene el nodo con la posición especificada
 * -buscarValor(valor): te retorna el índice que contiene el valor especificado, en la primer vez que aparezca
 * 
 * @author Miguel Alejandro
 */

public class ListaSimple { 
	// El primer nodo de la lista
	private Nodo cabeza;
	private int longitud;

	// Inserta un dato en la lista
	public void insertar(int dato) {
		Nodo nuevo = new Nodo(dato);
 
		if (cabeza == null) {
			cabeza = nuevo;
		} else {
			Nodo ultimo = obtenerUltimoNodo();
			ultimo.setSiguiente(nuevo);
		}

		longitud++;
	} 

	// Inserta un dato en la lista en una posición en específico
	public void insertar(int dato, int indice) {
		if (indice < 0 || indice >= longitud) {
			throw new IllegalArgumentException("Índice no válido");
		}

		Nodo nuevo = new Nodo(dato);

		// Si queremos insertarlo al inicio
		if (indice == 0) {
			nuevo.setSiguiente(cabeza);
			cabeza = nuevo;
		} else {
			Nodo actual = cabeza;
			// Tenemos que quedar un nodo antes del índice que queremos insertar
			for (int i = 0; i < indice - 1; i++) {
				actual = actual.getSiguiente();
			}
			nuevo.setSiguiente(actual.getSiguiente());
			actual.setSiguiente(nuevo);
		}

		longitud++;
	}

	// Eliminar un dato en la lista, según el índice, empezando en 0
	public void eliminar(int indice) {
		// Validamos que el índice sea correcto
		if (indice < 0 || indice >= longitud) throw new IllegalArgumentException("Índice no válido");

		// Si se quiere eliminar el primer nodo
		if (indice == 0) {
			cabeza = cabeza.getSiguiente();
		} else {
			Nodo actual = cabeza;

			for (int i = 0; i < indice - 1; i++) {
				actual = actual.getSiguiente();
			}

			// Tenemos la referencia del nodo anterior al nodo a eliminar
			Nodo nodoAEliminar = actual.getSiguiente();
			actual.setSiguiente(nodoAEliminar.getSiguiente());
		}

		longitud--;
	}

	// Eliminar un dato según un valor. Elimina la primer ocurrencia de ese valor
	public boolean eliminarPorDato(int valor) {
		if (cabeza == null) throw new NullPointerException("La lista está vacía");

		// Si el valor corresponde al del primer nodo
		if (valor == cabeza.getDato()) {
			cabeza = cabeza.getSiguiente();
			return true;
		}

		Nodo nodoActual = cabeza;

		for (int i = 0; i < longitud; i++) {
			Nodo siguiente = nodoActual.getSiguiente();
			int datoSiguiente = siguiente.getDato();

			if (datoSiguiente == valor) {
				nodoActual.setSiguiente(siguiente.getSiguiente());
				return true;
			}

			nodoActual = nodoActual.getSiguiente();
		}

		return false;
	}

	public int obtenerDatoEn(int indice) {
		if (indice < 0 || indice >= longitud) {
			throw new NoSuchElementException("El índice especificado no existe en la lista");
		}

		if (indice == 0) {
			return cabeza.getDato();
		} else {
			Nodo actual = cabeza;
			for (int i = 0; i < indice; i++) {
				actual = actual.getSiguiente();
			}
			return actual.getDato();
		}
	}

	// Buscar en qué posición está un nodo con un dato en específico
	// Te devuelve el índice en el que está, si existe dicho valor
	// Si no existe, retorna -1
	public int buscarValor(int valor) {
		if (cabeza == null) {
			throw new NullPointerException("La lista está vacía");
		}

		Nodo nodoActual = cabeza;

		for (int i = 0; i < longitud; i++) {
			int datoActual = nodoActual.getDato();
			if (datoActual == valor) {
				return i;
			}
			nodoActual = nodoActual.getSiguiente();
		}

		return -1;
	}

	public void imprimir() {
		if (cabeza == null) {
			throw new NullPointerException("La lista está vacía");
		}

		Nodo actual = cabeza;

		while (actual != null) {
			System.out.print(actual.getDato());
			if (actual.getSiguiente() != null) System.out.print(" -> ");
			actual = actual.getSiguiente();
		}
	}

	public Nodo obtenerUltimoNodo() {
		if (cabeza == null) {
			throw new NullPointerException("La lista está vacía");
		}

		Nodo actual = cabeza;
		while (actual.getSiguiente() != null) {
			actual = actual.getSiguiente();
		}

		// Hemos llegado al final de la lista
		return actual;
	}

	public void vaciar() {
		cabeza = null;
		longitud = 0;
	}

}