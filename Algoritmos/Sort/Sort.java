// Implementations of bubble sort algorithms to sort arrays in ascending order

public class Sort {
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) System.out.print(", ");
        }
        System.out.println("\n");
    }

    public static void bubbleSort(int[] arr) {
        while (true) {
            // Control variable to know if the swap happened
            boolean swap = false;

            // Iterate from the start to the second last position
            for (int i = 0; i < arr.length - 1; i++) {
                // If the actual element is greater than the next, we swap it}
                if (arr[i] > arr[i + 1]) {
                    int aux = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = aux;
                    swap = true;
                }
            }

            if (!swap) break;
        }
    }

    public static void bubbleSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    // Swap
                    int aux = arr[i];
                    arr[i] = arr[j];
                    arr[j] = aux;
                }
            }
        }
    }

    public static class Persona {
        private String nombre;
        private int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {4, 10, 3, 20, -1, 2, 100};
        Sort.printArr(arr);
        Sort.bubbleSort2(arr);
        Sort.printArr(arr);

        Sort.Persona p1 = new Sort.Persona("Coco", 12);

        int[] nums = {32, 12, 3213123};

        String name = "Miguel";
        String name2 = "Caca";

        System.out.println(p1.hashCode());  
        // System.out.println(name2.hashCode());
    }
}