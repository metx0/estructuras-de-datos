import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        while (true) {
            // Variable de control para saber si ha sucedido el swap
            boolean swap = false;

            // Iterar desde el inicio hasta el penúltimo elemento
            for (int i = 0; i < arr.length - 1; i++) {
                // Si el elemento actual es mayor al siguiente, hacemos swap
                if (arr[i] > arr[i + 1]) {
                    int aux = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = aux;
                    swap = true;
                }
            }

            System.out.println("-" + Arrays.toString(arr));
   
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
}