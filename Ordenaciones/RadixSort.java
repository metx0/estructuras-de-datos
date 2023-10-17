import java.util.Arrays;

public class RadixSort {
    public static int[] radixSort(int[] arr) {
        int max = getMax(arr);

        for (int exp = 1; max / exp > 0; exp *= 10)
            ordeningSort(arr, exp);
        
        return arr;
    }

    // Función de utilidad para obtener el mayor elemento de un arreglo
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static void ordeningSort(int[] arr, int exp) {
        int length = arr.length;

        int[] salida = new int[length];
        int[] orden = new int[10];

        // Calcular las ocurrencias de cada elemento
        for (int i = 0; i < length; i++ ) {
            int digito = (arr[i] / exp) % 10;
            orden[digito] += 1;
        }

        // Calcular la sumatoria acumulativa, algo así
        for (int i = 1; i < 10; i++) {
            orden[i] += orden[i - 1];
        }
        
        // Recorrer el arreglo desde el final al inicio y ordenarlo
        for (int i = length - 1; i >= 0; i--) {
            int digito = (arr[i] / exp) % 10;
            int index = orden[digito] - 1;
            // Ordenar el elemento en su posición correspondiente
            salida[index] = arr[i];
            // Decrementar el elemento correspondiente del array "orden"
            orden[digito] -= 1;            
        }

        System.out.println("-" + Arrays.toString(arr));

        // Se copia el array "salida" al array original
        for (int i = 0; i < length; i++) {
            arr[i] = salida[i];
        }
    }
}