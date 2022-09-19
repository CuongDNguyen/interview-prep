package blind75;

import java.util.Arrays;
import java.util.HashMap;

/*
Given an array of integers nums and an integer target,
 return indices of the two numbers such that
  they add up to target.

You may assume that each input would have exactly one solution,
 and you may not use the same element twice.

You can return the answer in any order.

Example:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].


 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 3};
        System.out.println(Arrays.toString(twoSums(nums, 6)));
        System.out.println(Arrays.toString(twoSumsOptimized(nums, 6)));
    }

    //My first attempt at solution
    static int[] twoSums(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && j != i) {
                    result[0] = j;
                    result[1] = i;
                }
            }
        return result;
    }

    //O(n) optimized solution
    static int[] twoSumsOptimized(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
