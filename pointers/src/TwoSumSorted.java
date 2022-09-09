import java.util.Arrays;

//2 pointers in opposite direction, sorted array
//Time complexity: O(n) Space Complexity: O(1)
public class TwoSumSorted {
    public static void main(String[] args) {
        int[] testTwoSumsInSortedArray = {1,2,2,2,3,3,3,3,4,4,4,4,5,23};

        System.out.println(Arrays.toString(twoSum(testTwoSumsInSortedArray, 24)));
    }

    static int[] twoSum(int[] numbers, int target) {

        int[] indice = new int[2];
        if (numbers == null || numbers.length < 2) {
            return indice;
        }

        int left = 0; //Start pointer
        int right = numbers.length -1; //End pointer

        while (left < right) {
            int x = numbers[left] + numbers[right];
            if (x == target) {
                indice[0] = left + 1;
                indice[1] = right + 1;
                break;
            } else if ( x > target) {
                right--;
            } else {
                left++;
            }
        }
        return indice;
    }
}
