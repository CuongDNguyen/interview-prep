import java.util.Arrays;

/*
The Tribonacci sequence Tn is defined as follows:

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
 */
public class TribonacciNumber {
    public static void main(String[] args) {
        System.out.println(tribonacciRecursive(4));
    }

    static int tribonacciRecursive(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        if (n == 0) {
            return cache[0] = 0;
        } else if (n == 1) {
            return cache[1] = 1;
        } else if ( n == 2) {
            return cache[2] = 1;
        } else if (cache[n] != -1) {
            return cache[n];
        } else {
                return cache[n];
            }
        }
}
