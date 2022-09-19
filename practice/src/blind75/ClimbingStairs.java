package blind75;

/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
 */

import java.util.HashMap;

public class ClimbingStairs {
    public static void main(String[] args) {

        System.out.println(differentClimbs(3));
        System.out.println(differentClimbsMemo(3));
    }

    //initial recursion w/ base cases
    static int differentClimbs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        return differentClimbs(n-1) + differentClimbs(n-2);
    }

    //recursion & memo
    static int differentClimbsMemo(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        memo.put(1,1);
        memo.put(2,2);
        return differentClimbsMemo(n, memo);
     }

     static int differentClimbsMemo(int n, HashMap<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        memo.put(n, differentClimbsMemo(n-1, memo) + differentClimbsMemo(n-2,  memo));
        return memo.get(n);
     }

    //dp solution bottom up
    static int differentClimbsDP(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
