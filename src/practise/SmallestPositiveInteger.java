package practise;

import java.util.Arrays;

public class SmallestPositiveInteger {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int index = 1;
       for (int count = 0; count < A.length; count++) {
           if (A[count] > 0 && A[count] == index) {
               index++;
           }
       }
        return index;
    }

    public static void main(String[] args) {
        int[] A =  {1, 3, 6, 4, 1,2};
//        int[] A =  {1, 2,3};
        System.out.println(solution(A));
    }
}
