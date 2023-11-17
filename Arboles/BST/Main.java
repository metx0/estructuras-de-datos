public class Main {
	public static void main(String[] args) {
		// Se crean los nodos a través de referencias
		/*Nodo raiz = new Nodo(1);
		raiz.izquierdo = new Nodo(2);
		raiz.derecho = new Nodo(3);
		raiz.izquierdo.izquierdo = new Nodo(4);
		raiz.izquierdo.derecho = new Nodo(5);

		ArbolBinario arbol = new ArbolBinario();*/		

		// System.out.println("Altura del árbol: ");
		// System.out.println(arbol.calcularAltura(raiz));

		// System.out.println("Factor de equilibrio: ");
		// System.out.println(arbol.calcularFactorEquilibrio(raiz));

		ArbolBinario bst = new ArbolBinario();
		bst.insertar(8);
		bst.insertar(10);
		bst.insertar(3);
		bst.insertar(6);
		bst.insertar(1);
		bst.insertar(14);
		bst.insertar(16);
		bst.insertar(13);
		
		System.out.println("Altura del árbol: " + bst.calcularAltura());
		System.out.println("Equilibrio: " + bst.calcularFactorEquilibrio(bst.raiz));
		System.out.println(bst.buscar(1));
		System.out.println("Valor mínimo del árbol: " + bst.encontrarMinimo());

		bst.remover(8);
		bst.imprimir();
	}
}