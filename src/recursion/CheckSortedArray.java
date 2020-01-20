package recursion;

public class CheckSortedArray {

	static int arraySortedOrNot(int array[], int n) {
		
		if(n==1 || n == 0) {
			return 1;
		}
		
		if(array[n-2] > array[n-1]) {
			return 0;
		}
		
		return arraySortedOrNot(array, n-1);
		
	}
	
	public static void main(String[] args) {
		
		int array[] = {20, 23, 23, 45, 78, 88, 7 }; 
		int n = array.length;
		if(arraySortedOrNot(array, n) != 0)
			System.out.println("Yes");
		else 
			System.out.println("No");
	}

}
