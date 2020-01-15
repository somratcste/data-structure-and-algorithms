public class RunnerUp
{
    public static void main(String args[])
    {
        int array[] = {60,70, 80, 70, 90, 90, 90, 90, 60, 72, 82, 83, 50, 92, 20};
        int max = array[0]; int rp = array[0]; int temp = 0;
        for (int i = 1; i<array.length; i++) {

            if(max < array[i]) {
                temp = max;
                max = array[i];
                rp = temp;
            }
            if(max > array[i] && rp < array[i] ) {
                rp = array[i];
            }
        }
        System.out.printf("Final rp: %d", rp);
    }
}