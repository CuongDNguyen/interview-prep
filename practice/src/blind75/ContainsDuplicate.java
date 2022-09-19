package blind75;

import java.util.HashSet;

/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]
Output: true
 */
public class ContainsDuplicate {
    public static void main(String[] args) {

        int[] nums = new int[] {1,2,3,1};
        System.out.println(containDuplicate(nums));
    }

    static boolean containDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (!hashSet.add(num)) {
                return true;
            }
        }
        return false;
    }
}
