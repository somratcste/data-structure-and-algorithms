package backtracking;

public class PossibleString {

	public static void main(String[] args) {
		
		System.out.println("First Test");
		char[] set1 = {'a', 'b' };
		int k = 3; 
		printAllKlength(set1, k);
		
		System.out.println("\nSecond Test");
		char[] set2 = {'a', 'b', 'c', 'd'};
		k = 1;
		printAllKlength(set2, k);

	}

	private static void printAllKlength(char[] set, int k) {
		int n = set.length;
		printAllKlengthRec(set, "", n, k);
		
	}

	private static void printAllKlengthRec(char[] set, String prefix, int n, int k) {
		
		if(k == 0) {
			System.out.println(prefix);
			return;
		}
		
		for(int i = 0; i<n; ++i) {
			String newPrefix = prefix + set[i];
			printAllKlengthRec(set, newPrefix, n, k-1);
		}
		
	}

}
