// Test de la clase ListaSimplementeEnlazada

public class Main {
	public static void main(String[] args) {
        ListaSimplementeEnlazada lista1 = new ListaSimplementeEnlazada();

        int[] valores = {5, 59, 91, -17, 73, 34, 40};

        // Para cada elemento del arreglo
        for (int valor : valores) {
            lista1.insertar(valor);
        }

        lista1.eliminar(2);
        lista1.eliminar(3);

        System.out.println(lista1.obtener(3));
	}
}