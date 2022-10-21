package yahoo;

import java.util.Arrays;
import java.util.HashSet;

public class FindTripletsInArrayWithGivenSum {
    public static void main(String[] args) {
        int A[] = { 1, 4, 45, 6, 10, 8 };
        int sum = 22;
        int arr_size = A.length;

        getTriplets(A, arr_size, sum);
    }

    static void getTriplets(int[] nums, int size, int sum) {

        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            int currentSum = sum - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (set.contains(currentSum-nums[i])) {
                    System.out.println("Triplets");
                    System.out.println(nums[i]);
                    System.out.println(nums[j]);
                    System.out.println(currentSum - nums[j]);
                }
                set.add(nums[j]);
            }
        }
    }
}
