/*
Esta clase provee métodos para insertar, buscar y eliminar datos en árboles AVL
Tiene una complejidad de O(logn) para esas 3 operaciones
En los árboles AVL, después de cada inserción y eliminación, se comprueba el factor de equilibrio
de cada nodo, para verificar si es necesario hacer rotaciones y mantenerlo balanceado
*/

public class ArbolAVL {
	private Nodo raiz;

	public ArbolAVL() {}

	public void insertar(int dato) {
		raiz = insertarRec(raiz, dato);
	}

	// Método recursivo auxiliar para la inserción
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
		} else {
			return raiz;
		}

		return aplicarRotacion(raiz);
	}

	public void remover(int dato) {
		if (!buscarRec(raiz, dato)) {
			System.out.printf("El dato %d no se encuentra en el árbol\n", dato);
			return;
		}

		// Si se encuentra, se llama a la función recursiva
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
				raiz.dato = obtenerMinimo(raiz.derecho);
				raiz.derecho = removerRec(raiz.derecho, raiz.dato);
			} else { 
				// Si tiene un hijo izquierdo, hallar un predecesor para reemplazar el nodo
				raiz.dato = obtenerMaximo(raiz.izquierdo);
				raiz.izquierdo = removerRec(raiz.izquierdo, raiz.dato);
			}
		}

		return raiz;
	}

	private Nodo aplicarRotacion(Nodo raiz) {
		int balance = calcularFactorEquilibrio(raiz);

		// imbalance left-left
		if (balance > 1) {
			if (calcularFactorEquilibrio(raiz.izquierdo) < 0) {
				raiz.izquierdo = rotarIzquierda(raiz.izquierdo);
			}
			return rotarDerecha(raiz);
		}
		if (balance < -1) {
			if (calcularFactorEquilibrio(raiz.derecho) > 0) {
				raiz.derecho = rotarDerecha(raiz.derecho);
			}
			return rotarIzquierda(raiz);
		}

		return raiz;
	}

	// Rotaciones

	private Nodo rotarIzquierda(Nodo raiz) {
		Nodo nodoDerecho = raiz.derecho;
		Nodo nodoCentro = nodoDerecho.izquierdo;

		nodoDerecho.izquierdo = raiz;
		raiz.derecho = nodoCentro;

		return nodoDerecho;
	}

	private Nodo rotarDerecha(Nodo raiz) {
		Nodo nodoIzquierdo = raiz.izquierdo;
		Nodo nodoCentro = nodoIzquierdo.derecho;

		nodoIzquierdo.derecho = raiz;
		raiz.izquierdo = nodoCentro;

		return nodoIzquierdo; 
	}

	// Similar a la búsqueda en BST
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

	// Obtener el mínimo y el máximo elemento del subárbol de un nodo

	public int obtenerMinimo(Nodo raiz) {
		while (raiz.izquierdo != null) {
			raiz = raiz.izquierdo;
		}

		return raiz.getDato();
	}

	public int obtenerMaximo(Nodo raiz) {
		while (raiz.derecho != null) {
			raiz = raiz.derecho;
		}

		return raiz.getDato();
	}

	// Imprimimos los datos de forma ascendente (recorrido infijo)
	public void imprimir() {
		if (raiz == null) {
			System.out.println("No hay elementos en el árbol");
		}

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

	public Nodo getRaiz() {
		return raiz;
	}
}