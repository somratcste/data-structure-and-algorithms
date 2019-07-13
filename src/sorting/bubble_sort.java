package sorting;

public class bubble_sort {

	public static void main(String[] args) {
		int[] unsortedArray = {20, 35, -15, 7, 55, 1, -22};
		
		for(int i = unsortedArray.length-1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				
				if(unsortedArray[j] > unsortedArray[j+1]) {
					swap(unsortedArray, j, j+1);
				}
			}
		}
		
		for(int i = 0; i < unsortedArray.length; i++) {
			System.out.print(unsortedArray[i]+ " ");
		}
		
	} 
	
	private static void swap(int[] array, int i, int j) {
		if( i == j) {
			return;
		}
		
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}