// Implementaciones de los algoritmos de búsqueda lineal y binaria

public class Search {
	// Busca en un arreglo de enteros. Devuelve el índice del elemento, si existe. Si no, retorna -1
	public static int linearSearch(int[] nums, int element) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == element) {
				return i;
			}
		}

		return -1;
	}

	public static int binarySearch(int[] nums, int element) {
		int low = 0;
		int high = nums.length -1;

		while (low <= high) {
			int mid = (low + high) / 2;
			int midElem = nums[mid];

			if (midElem == element) {
				return mid;
			} else if (midElem < element) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}
}