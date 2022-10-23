package search;

/**
 * https://www.geeksforgeeks.org/binary-search/
 * time complexity: O(log n) || Space Complexity: O(1)
 * int mid = low + (high – low)/2; to avoid SumOverflow problem for a big int sum
 */
public class BinarySearch {

    private static void binarySearch(int[] v, int toFind) {
        int low = 0, high = v.length - 1;
        while (high - low > 1) {
            int mid = low + (high - low)/2;
            if (v[mid] < toFind) {
                low = mid + 1;
            } else  {
                high = mid;
            }
        }

        if (v[low] == toFind) {
            System.out.println("Found At Index: " + low);
        } else if (v[high] == toFind) {
            System.out.println("Found At Index: " + high);
        } else {
            System.out.println("Not Found!");
        }
    }

    public static void main(String[] args) {
        int v[] = {1, 3, 4, 5, 6};

        int toFind = 1;
        binarySearch(v, toFind);
        toFind = 6;
        binarySearch(v, toFind);
        toFind = 10;
        binarySearch(v, toFind);
    }
}
