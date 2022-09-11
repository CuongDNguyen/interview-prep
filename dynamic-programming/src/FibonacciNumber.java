import java.util.Arrays;

/*

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Example 1:

Input: n = 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 */
public class FibonacciNumber {

    public static void main(String[] args) {

        System.out.println(getFibonnaciRecursive(6));
        System.out.println(getFibonacciMemo(6));
    }

    static int getFibonnaciRecursive(int n) {
        if (n > 1) {
            return getFibonnaciRecursive(n - 1) + getFibonnaciRecursive( n - 2);
        } else {
            return n;
        }
    }

    static int getFibonacciMemo(int n) {
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);

        if (n == 0)
            return cache[0] = 0;
        else if (n == 1) {
            return cache[1] = 1;
        } else if (cache[n] != -1) {
            return cache[n];
        } else {
            return cache[n] = getFibonacciMemo(n-1) + getFibonacciMemo(n-2);
        }
    }
}
