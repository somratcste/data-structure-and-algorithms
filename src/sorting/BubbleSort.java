package sorting;

/**
 * https://www.geeksforgeeks.org/bubble-sort/
 * Concept: Illustration
 */
public class BubbleSort {

	static void bubbleSort(int[] arr, int arrayLength) {
		int i, j, temp;
		boolean swapped;
		for (i =0; i <arrayLength-1; i++) {
			swapped = false;
			for (j=0; j<arrayLength-i-1; j++) {
				if (arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}

	static void printArray(int[] arr, int arrayLength) {
		for (int i=0; i<arrayLength; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		int arr[] = {64, 34, 25, 12, 22, 11, 90};
		int arrayLength = arr.length;
		bubbleSort(arr, arrayLength);
		System.out.println("Bubble Sorted Array: ");
		printArray(arr, arrayLength);
	}
}