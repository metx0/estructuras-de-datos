public class Test {
    public static void main(String[] args) {
        ListaSimple lista1 = new ListaSimple();

        int[] valores = {5, 59, 91, -17, 73, 34, 34, 40};

        for (int valor : valores) {
            lista1.insertar(valor);
        }

        lista1.eliminar(8);

        lista1.imprimir();
    }
}