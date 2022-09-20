package blind75;

import java.util.Arrays;
import java.util.HashMap;

/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements
 without changing the order of the remaining elements.

 For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].


Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Algorithm:
10 > 9, remove 10 from the possible solution
9 > 2, remove 9 from the possible solution
2 < 5, start at 2 and count is 1
5 > 3, remove 5 from possible solution, max count is 2,
start at 2 and go 3, 3 < 7, 7 < 101, 101 > 18,

go through list of nums
for each num, find num[i] < num[i + 1] where i + 1 < length index - 1, start count from here, if none return 0

 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(countIncreasingSubsequence(nums));
    }

        static int countIncreasingSubsequence(int[] nums) {
            int lengthArray = nums.length;
            int[] dp = new int[lengthArray];
            Arrays.fill(dp, 1);
            int max = 1;
            for (int i = 1; i < lengthArray; i++) {
                for (int j = 0; j <= i - 1; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], 1 + dp[j]);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
}
