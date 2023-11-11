public class Main {
	public static void main(String[] args) {
		Arbol <Character> arbolGeneral = new Arbol<>('A', false);
		NodoArbol raiz = arbolGeneral.obtenerRaiz();

		arbolGeneral.agregarNodoArbol(raiz, new NodoArbol('B'));
		arbolGeneral.agregarNodoArbol(raiz, new NodoArbol('C'));
		arbolGeneral.agregarNodoArbol(raiz, new NodoArbol('D'));

		arbolGeneral.imprimirArbol(Recorrido.PREFIJO);
	}
}