/* 
Autor: Miguel Alejandro Torruco
Fecha: 09/09/23
*/

public class Main {
	public static void main(String[] args) {
		Pila p1 = new Pila();
		int[] numeros = {14, 27, 1, 15, 10, 90, 71, 37, 2, 48};

		// Insertar los números con un bucle
		for (int i = 0; i < numeros.length; i++) {
			p1.insertar(numeros[i]);
		}

		// Imprimir el tamaño de la pila
		System.out.println("Tamaño: " + p1.getTamanio());

		System.out.println("Quitando 4 elementos...");
		// Quitar 4 elementos
		for (int i = 0; i <	4; i++) {
			p1.quitar();
		}

		// Imprimir elemento de la cima de la pila
		System.out.println("Elemento en la cima: " + p1.obtenerCima());

		// Vaciar la pila
		p1.vaciar();

		System.out.println("¿La pila está vacía? " + p1.estaVacia());

		/*
		Salida:
		Tamaño: 10
		Quitando 4 elementos...
		Elemento en la cima: 90
		¿La pila está vacía? true
		*/
	}
}