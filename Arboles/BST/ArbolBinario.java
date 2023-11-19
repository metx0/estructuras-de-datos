/*
Un árbol es binario si cada nodo tiene como máximo dos hijos
Esta clase representa un árbol de búsqueda binario (Binary search tree)
En un árbol de búsqueda binario, el dato del hijo izquierdo de un nodo es menor a él y el dato del hijo derecho
es mayor a él 
La complejidad de buscar un dato en un árbol de búsqueda binario es O(logn)
*/

public class ArbolBinario {
	public Nodo raiz;

	public ArbolBinario() {}

	public ArbolBinario(int dato) {
		this.raiz = new Nodo(dato);
	}

	public void insertar(int dato) {
		raiz = insertarRec(raiz, dato);
	}

	// Método auxiliar para realizar la inserción recursivamente
	private Nodo insertarRec(Nodo raiz, int dato) {
		if (raiz == null) {
			return new Nodo(dato);
		} 

		if (dato < raiz.dato) {
			// Insertarlo a la izquierda del último nodo
			raiz.izquierdo = insertarRec(raiz.izquierdo, dato);
		} else if (dato > raiz.dato) {
			// Insertarlo a la derecha del último nodo
			raiz.derecho = insertarRec(raiz.derecho, dato);
		}

		return raiz;
	}

	public boolean buscar(int dato) {
		return buscarRec(raiz, dato);
	}

	// Método auxiliar para buscar recursivamente
	private boolean buscarRec(Nodo raiz, int dato) {
		// Si el dato no se encuentra o el árbol está vacío
		if (raiz == null) return false;

		if (dato == raiz.dato) {
			return true;
		} else if (dato < raiz.dato) {
			return buscarRec(raiz.izquierdo, dato);
		} else { // Si el dato es mayor
			return buscarRec(raiz.derecho, dato);
		}
	}

	// Remueve el nodo que contenga el dato, si se encuentra
	// Hace uso de buscar() para saber si el dato a remover se encuentra en el árbol
	public void remover(int dato) {
		if (!buscar(dato)) {
			System.out.printf("El dato %d no se encuentra en el árbol", dato);
			return;
		}

		// Llamada a la función recursiva
		removerRec(raiz, dato);
	}

	private Nodo removerRec(Nodo raiz, int dato) {
		if (raiz == null) {
			return raiz;
		}

		if (dato < raiz.dato) {
			// Buscar en la izquierda
			raiz.izquierdo = removerRec(raiz.izquierdo, dato);
		} else if (dato > raiz.dato) {
			// Buscar por la derecha
			raiz.derecho = removerRec(raiz.derecho, dato);
		} else { // Si encontramos el nodo a remover
			// Si el nodo es una hoja
			if (raiz.izquierdo == null && raiz.derecho == null) {
				raiz = null;
			} else if (raiz.derecho != null) { // Si tiene un hijo derecho
				// Hallar un sucesor para reemplazar el nodo a eliminar
				// Reemplazamos el dato del nodo, más bien
				raiz.dato = sucesor(raiz);
				raiz.derecho = removerRec(raiz.derecho, raiz.dato);
			} else { // Si tiene un hijo izquierdo
				// Hallar un predecesor para reemplazar el nodo
				raiz.dato = predecesor(raiz);
				raiz.izquierdo = removerRec(raiz.izquierdo, raiz.dato);
			}
		}

		return raiz;
	}

	// sucesor y predecesor ayudan en la eliminación de nodos

	// Encontrar el menor valor del subárbol derecho de "raiz"
	public int sucesor(Nodo raiz) {
		Nodo actual = raiz.derecho;

		while (actual.izquierdo != null) {
			actual = actual.izquierdo;
		}

		return actual.dato;
	}

	// Encontrar el mayor valor del subárbol izquierdo de "raiz"
	private int predecesor(Nodo raiz) {
		Nodo actual = raiz.izquierdo;

		while (actual.derecho != null)  {
			actual = actual.derecho;
		}

		return actual.dato;
	}

	// Encontrar el menor dato presente en el árbol
	public int encontrarMinimo() {
		if (raiz == null) {
			System.out.println("No hay elementos en el árbol");
			return -1;
		}

		return encontrarMinimo(raiz);
	}

	// Encontrar el valor mínimo en un subárbol (el nodo que está más a la izquierda)
	private int encontrarMinimo(Nodo raiz) {
		while (raiz.izquierdo != null) {
			raiz = raiz.izquierdo;
		}

		return raiz.dato;
	}

	// Calcular la altura del árbol en sí, si tiene elementos
	public int calcularAltura() {
		if (raiz == null) return -1;

		return calcularAltura(raiz);
	}

	// Calcular la altura de un determinado nodo
	private int calcularAltura(Nodo nodo) {
		if (nodo == null) {
			return 0;
		}

		// Obtener la altura de los subárboles izquierdo y derecho
		int alturaIzquierda = calcularAltura(nodo.izquierdo);
		int alturaDerecha = calcularAltura(nodo.derecho); 

		// La altura del árbol es la máxima altura de los subárboles más 1
		return Math.max(alturaIzquierda, alturaDerecha) + 1;
	}

	// El factor de equilibrio es la diferencia entre la altura del subárbol izquierdo y la
	// del subárbol derecho
	public int calcularFactorEquilibrio(Nodo nodo) {
		int alturaIzquierda = calcularAltura(nodo.izquierdo);
		int alturaDerecha = calcularAltura(nodo.derecho);

		return alturaIzquierda - alturaDerecha;
	}

	// Imprimimos los datos de forma ascendente
	public void imprimir() {
		infijoRec(raiz);
	}
	
	// Método auxiliar, que hace un recorrido infijo del árbol
	private void infijoRec(Nodo raiz) {
		if (raiz != null) {
			infijoRec(raiz.izquierdo);
			System.out.print(raiz.dato + "  ");
			infijoRec(raiz.derecho);		
		}
	}
}