/* 
Autor: Miguel Alejandro Torruco
Fecha: 09/09/23
*/

public class Pila {
	// El último nodo que se ha insertado. Cuando se crea, "cima" es null
	private Nodo cima;
	// La cantidad total de nodos que tiene la pila
	private int tamanio;

	// Operaciones

	// Insertar un elemento en la cima
	public void insertar(int dato) {
		Nodo nuevo = new Nodo(dato);

		// Si es el primer nodo
		if (cima == null) {
			cima = nuevo;
		} else { // Si ya hay un nodo en la cima
			nuevo.setSiguiente(cima);
			cima = nuevo;
		}

		tamanio++;
	}

	// Quitar el elemento de la cima
	public void quitar() {
		if (cima == null) {
			System.out.println("No hay elementos en la pila");
		} else {
			Nodo temp = cima;
			cima = temp.getSiguiente();	
			tamanio--;
		}
	}

	// Vaciar la pila. Lo hacemos asignando un valor nulo a "cima" y al tamaño un valor de 0
	public void vaciar() {
		cima = null;
		tamanio = 0;
	}

	public boolean estaVacia() {
		// Podemos comprobar si está vacía con el tamaño o preguntando si la cima es nula
		// Lo hacemos con el tamaño
		if (tamanio == 0) {
			return true;
		} else {
			return false;
		}
	}


	public int obtenerCima() {
		if (cima == null) {
			System.out.println("No hay elementos en la pila");
			return -1;
		} else {
			return cima.getDato();
		}
	}

	public int getTamanio() {
		return tamanio;
	}
}