package data_structure.arrays;

public class ArrayInsertionDifferentPosition {
    public static void main(String[] args) {
        int number = 5, index=3, sequentialCount = 2;
        int value1=10, value2=20, value3 = 30;
        int position1 = 2, position2 = 5, position3 = 8;
        int[] A = new int[number+sequentialCount];

        for(int i=0; i<number; i++) {
            A[i] = i+1;
        }

        System.out.println("Your array: ");
        for(int i=0; i<number; i++) {
            System.out.println(i + " => " + A[i]);
        }

        for(int i= number-1; i>= index-1; i--) {
            A[i+sequentialCount] = A[i];
        }

        A[index-1] = value1;
        A[index] = value2;

        System.out.println("After Inserting: ");
        for(int i=0; i<number+sequentialCount; i++) {
            System.out.println(i + " => " + A[i]);
        }
    }
}
