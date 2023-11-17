public class Main {
	public static void imprimirArbolGeneral() {
		// Creamos un árbol general que contiene caracteres
		Arbol <Character> arbolGeneral = new Arbol<>('A', false);
		NodoArbol raiz = arbolGeneral.getRaiz();

		// Agregaremos todos los nodos por referencias

		// Agregamos los hijos de la raíz
		char[] hijosRaiz = {'B', 'C', 'D'};
		for (char hijo : hijosRaiz) {
			arbolGeneral.agregarNodoArbol(raiz, new NodoArbol(hijo));
		}

		// Agregamos los hijos de B
		arbolGeneral.agregarNodoArbol(raiz.getPrimerHijo(), new NodoArbol('E'));
		arbolGeneral.agregarNodoArbol(raiz.getPrimerHijo(), new NodoArbol('F'));

		// Obtener el segundo hijo de B
		NodoArbol f = raiz.getPrimerHijo().obtenerEnesimoHijo(2);

		// A F hay que agregarle J, K, L
		char[] hijosF = {'J', 'K', 'L'};
		for (char hijo : hijosF) {
			arbolGeneral.agregarNodoArbol(f, new NodoArbol(hijo));
		}

		// El tercer hijo de la raíz es D
		NodoArbol d = raiz.obtenerEnesimoHijo(3);

		char[] hijosD = {'G', 'H', 'I'};
		for (char hijo : hijosD) {
			arbolGeneral.agregarNodoArbol(d, new NodoArbol(hijo));
		}

		arbolGeneral.agregarNodoArbol(d.getPrimerHijo(), new NodoArbol('M'));

		// A M se le añade P y Q
		arbolGeneral.agregarNodoArbol(d.getPrimerHijo().getPrimerHijo(), new NodoArbol('P'));
		arbolGeneral.agregarNodoArbol(d.getPrimerHijo().getPrimerHijo(), new NodoArbol('Q'));

		// A I se le añaden N y O. I es el tercer hijo de D
		NodoArbol i = d.obtenerEnesimoHijo(3);
		arbolGeneral.agregarNodoArbol(i, new NodoArbol('N'));
		arbolGeneral.agregarNodoArbol(i, new NodoArbol('O'));

		System.out.println("Imprimiendo el árbol general: \n");
		arbolGeneral.imprimirArbol(Recorrido.PREFIJO);
		arbolGeneral.imprimirArbol(Recorrido.INFIJO);
		arbolGeneral.imprimirArbol(Recorrido.POSFIJO);

		System.out.println("Altura del árbol general: " + arbolGeneral.obtenerAltura(raiz));
	}

	public static void main(String[] args) {
		// Main.imprimirArbolGeneral();

		// Conversión del árbol general a binario
		// Creamos un arreglo de nodos y se crea el elemento en base al arreglo de nombres
		char[] nombresBinario = {'B', 'E', 'F', 'J', 'K', 'L', 'C', 'D', 'G', 'M', 'P', 'Q', 'H', 'I', 'N', 'O'};
		NodoArbol[] nodosBinarios = new NodoArbol[16];

		for (int i = 0; i < nombresBinario.length; i++) {
			nodosBinarios[i] = new NodoArbol(nombresBinario[i]);
		}

		Arbol <Character> arbolBinario = new Arbol<>('A', true);
		NodoArbol raizBinario = arbolBinario.getRaiz();

		// Se añaden manualmente, usando el arreglo de nodos binarios
		arbolBinario.agregarNodoArbol(raizBinario, nodosBinarios[0]);
		arbolBinario.agregarNodoArbol(nodosBinarios[0], nodosBinarios[1]);
		// arbolBinario.agregarNodoArbol(nodosBinarios[0], nodosBinarios[6]);
		// arbolBinario.agregarNodoArbol(nodosBinarios[1], nodosBinarios[2]);
		// arbolBinario.agregarNodoArbol(nodosBinarios[2], nodosBinarios[3]);
		// arbolBinario.agregarNodoArbol(nodosBinarios[3], nodosBinarios[4]);
		// arbolBinario.agregarNodoArbol(nodosBinarios[4], nodosBinarios[5]);
		// arbolBinario.agregarNodoArbol(nodosBinarios[6], nodosBinarios[7]);
		// arbolBinario.agregarNodoArbol(nodosBinarios[7], nodosBinarios[8]);
		// arbolBinario.agregarNodoArbol(nodosBinarios[8], nodosBinarios[9]);
		// arbolBinario.agregarNodoArbol(nodosBinarios[8], nodosBinarios[12]);
		// arbolBinario.agregarNodoArbol(nodosBinarios[9], nodosBinarios[10]);
		// arbolBinario.agregarNodoArbol(nodosBinarios[10], nodosBinarios[11]);
		// arbolBinario.agregarNodoArbol(nodosBinarios[12], nodosBinarios[13]);
		// arbolBinario.agregarNodoArbol(nodosBinarios[13], nodosBinarios[14]);
		// arbolBinario.agregarNodoArbol(nodosBinarios[14], nodosBinarios[15]);

		// System.out.println("\n\nImprimiendo el árbol binario: \n");
		// arbolBinario.imprimirArbol(Recorrido.PREFIJO);
		// arbolBinario.imprimirArbol(Recorrido.INFIJO);
		// arbolBinario.imprimirArbol(Recorrido.POSFIJO);

		// System.out.print("\n¿Está vacío el árbol? ");
		// System.out.println(arbolBinario.estaVacio());

		// Obtener la altura del árbol binario
		System.out.print("La altura del árbol es: ");
		System.out.println(arbolBinario.obtenerAltura(raizBinario));

		// System.out.println("Imprimiendo el subárbol del nodo 'G': ");

		// Imprimimos el subárbol del nodo 7 en notación prefija
		// arbolBinario.imprimirSubArbol(nodosBinarios[8], Recorrido.PREFIJO);
	}
}