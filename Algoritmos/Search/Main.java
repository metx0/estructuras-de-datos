// Test de los algoritmos de búsqueda

public class Main {
	public static void main(String[] args) {
		int[] numbers = {4, 10, 322, 65, -1, 32, 88, 15, 2, 66};
		int result = Search.linearSearch(numbers, 2);
		System.out.println(result);

		int[] sortedList = {-1, 5, 12, 13, 18, 20, 29, 33, 72, 187, 190, 346, 950, 1000, 1250};
		System.out.println(Search.binarySearch(sortedList, 950));
	}
}