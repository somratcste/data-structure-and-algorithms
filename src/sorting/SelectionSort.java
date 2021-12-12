package sorting;

/**
 * https://www.geeksforgeeks.org/selection-sort/
 */
public class SelectionSort {

	static void selectionSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i< n-1; i++) {
			int min_idx = i;
			for (int j = i+1; j < n; j++) {
				if (arr[min_idx] > arr[j]) {
					min_idx = j;
				}
			}

			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
	}

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i]+" ");
		System.out.println();
	}

	public static void main(String args[])
	{
		int arr[] = {64,25,12,22,11};
		selectionSort(arr);
		printArray(arr);
	}
}
