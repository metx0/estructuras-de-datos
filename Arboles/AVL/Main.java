import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArbolAVL avl = new ArbolAVL();
		avl.insertar(50);
		avl.insertar(40);
		avl.insertar(35);
		avl.insertar(60);
		avl.insertar(20);
		avl.insertar(45);

		System.out.println("Árbol AVL: ");
		avl.imprimir();

		Scanner sc = new Scanner(System.in);
		System.out.print("\nDigite el dato del nodo a buscar: ");

		int datoABuscar = sc.nextInt();

		if (avl.buscar(datoABuscar)) {
			System.out.printf("El dato %d se ha encontrado en el árbol\n", datoABuscar);
		} else {
			System.out.printf("El dato %d NO se ha encontrado en el árbol\n", datoABuscar);
		}

		System.out.print("Digite el dato del nodo a eliminar: ");
		int datoAEliminar = sc.nextInt();

		avl.remover(datoAEliminar);
		avl.imprimir();
	}
}