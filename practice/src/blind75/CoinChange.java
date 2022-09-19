package blind75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
You are given an integer array coins representing coins of different denominations
 and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Check to see if coin combination can equal amount
Find the highest coin and use that first
Find the second highest coin and use that second...
 */
public class CoinChange {
    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 11));
    }

    static int coinChange(int[] coins, int amount) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return coinChange(coins, amount, memo);
    }

    static int coinChange(int[] coins, int amount, HashMap<Integer, Integer> memo) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        Integer coin = memo.get(amount);
        if (coin != null) return coin;
        int coinAmount = -1;

        for (int i = 0; i < coins.length; i++) {
            int currentCoin = coinChange(coins, amount - coins[i], memo);
            if (currentCoin >= 0) {
                coinAmount = coinAmount < 0 ? currentCoin + 1 :
                        Math.min(coinAmount, currentCoin + 1);
            }
        }
        memo.put(amount, coinAmount);
        return coinAmount;
    }
}
