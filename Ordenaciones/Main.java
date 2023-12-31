import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] arrToQuickSort = { 351, 33, 42, 110, 14, 919, 27, 1144, 216, 311, 0 };
		int[] arrToRadixSort = { 351, 33, 42, 110, 14, 919, 27, 1144, 216, 311, 0 };
		int[] arrToMergeSort = { 351, 33, 42, 110, 14, 919, 27, 1144, 216, 311, 0 };
		int[] arrToBubbleSort = { 351, 33, 42, 110, 14, 919, 27, 1144, 216, 311, 0 };

		// Arrays.toString(arr) es para imprimir el arreglo como una string
	 
		// System.out.println("Array ordenado con QuickSort:");
		// System.out.println("Antes: " + Arrays.toString(arrToQuickSort));
		// int[] arrQuickSort = QuickSort.quickSort(arrToQuickSort);
		// System.out.println("Ahora: " + Arrays.toString(arrQuickSort) + "\n");

		// System.out.println("Array ordenado con RadixSort:");
		// System.out.println("Antes: " + Arrays.toString(arrToRadixSort));
		// int[] arrRadixSort = RadixSort.radixSort(arrToRadixSort);
		// System.out.println("Ahora: " + Arrays.toString(arrRadixSort) + "\n");

		// System.out.println("Array ordenado con MergeSort:");
		// System.out.println("Antes: " + Arrays.toString(arrToMergeSort));
		// int[] arrMergeSort = MergeSort.mergeSort(arrToMergeSort);
		// System.out.println("Ahora: " + Arrays.toString(arrMergeSort));

		// System.out.println("Array ordenado con BubbleSort:");
		// System.out.println("Antes: " + Arrays.toString(arrToBubbleSort));
		// // bubbleSort() modifica el arreglo original
		// BubbleSort.bubbleSort(arrToBubbleSort);
		// System.out.println("Ahora: " + Arrays.toString(arrToBubbleSort));

		int[] arr = {346, 72, 13, 187, 29, 1250, 950, 12, 1000, 18, -1, 20, 33, 190, 5};
		System.out.println(Arrays.toString(MergeSort.mergeSort(arr)));
		// BubbleSort.bubbleSort(arr);
	}
}