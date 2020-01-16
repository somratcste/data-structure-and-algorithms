package arrays;

public class InsertBeginning {
    public static void main(String[] args) {
        int number = 5;
        int[] A = new int[number+1];
        for(int i=0; i<number; i++) {
            A[i] = i+1;
        }

        int value = 10;
        System.out.println("Your array: ");
        for(int i=0; i<number; i++) {
            System.out.println(i + " => " + A[i]);
        }

        for(int i= number-1; i>=0; i--) {
            A[i+1] = A[i];
        }
        A[0] = value;

        System.out.println("After Inserting: ");
        for(int i=0; i<=number; i++) {
            System.out.println(i + " => " + A[i]);
        }
    }
}
