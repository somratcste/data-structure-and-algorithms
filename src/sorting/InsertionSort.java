package sorting;

/**
 * https://www.geeksforgeeks.org/insertion-sort/
 */
public class InsertionSort {

	static void insertionSort(int[] arr) {
		for (int i=1; i < arr.length; i++) {
			int key = arr[i];
			int j = i-1;
			/**
			 * Move elements of arr [0,,,i-1], that are greater than key,
			 * to one position ahead of their current position
			 */
			while (j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j-1;
			}
			arr[j+1] = key;
		}
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
	}

	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6};
		insertionSort(arr);
		printArray(arr);
	}
}
