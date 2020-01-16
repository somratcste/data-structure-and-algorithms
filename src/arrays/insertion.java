package arrays;

import java.util.Scanner;

public class insertion {
    public static void main(String[] args) {

        int number, position, value;
        System.out.println("Enter number of elements in array: ");
        Scanner s = new Scanner(System.in);
        number = s.nextInt();

        int[] A = new int[number+1];
        System.out.println("Enter all elements: ");
        for(int i = 0; i<number; i++) {
            A[i] = s.nextInt();
        }

        System.out.println("Your array: ");
        for(int i=0;i<=number; i++) {
            System.out.println(i + " => " + A[i]);
        }

        System.out.println("Enter the position for insert value: ");
        position = s.nextInt();

        System.out.println("Enter your element: ");
        value = s.nextInt();

        for(int i=number-1; i>= position-1; i--) {
            A[i+1] = A[i];
        }
        A[position-1] = value;

        System.out.println("After inserting: ");
        for(int i = 0; i<=number; i++) {
            System.out.println(i + " => " + A[i]);
        }

    }
}
