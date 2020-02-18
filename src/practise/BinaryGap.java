package practise;

import java.util.Scanner;

public class BinaryGap {
    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );

        System.out.println("Enter Integer: ");
        String integerString =input.nextLine();
//        String binary = Integer.toBinaryString(Integer.parseInt(integerString));
        System.out.println(solution(Integer.parseInt(integerString)));
    }

    private static int solution(int N) {
        String binary = Integer.toBinaryString(N);
        int zeroCount = 0;
        int longZeroCount = 0;

        for(int i =0; i< binary.length(); i++) {
            int number = Character.getNumericValue(binary.charAt(i));
            if(number == 0) {
                zeroCount++;
            }

            if(number == 1 &&  zeroCount != 0) {
                if(zeroCount > longZeroCount) {
                    longZeroCount = zeroCount;
                    zeroCount = 0;
                } else {
                    zeroCount = 0;
                }
            }
        }

        return longZeroCount;
    }
}
