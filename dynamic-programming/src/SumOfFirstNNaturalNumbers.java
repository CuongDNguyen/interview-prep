//Recursion uses stack so it is costly
//Example 1+2+3+.... n
//sum(n) = sum(n-1) + n
/*
sum(n) = {    0            (n == 0)
           sum(n-1) + n   (n > 0)

n(n+1)/2
 */

public class SumOfFirstNNaturalNumbers {

    public static void main(String[] args) {

    }

    //Time: O(n)  Space: O(n)
    static int sumRecursion(int n) {
        if (n == 0) {
            return 0;
        }

        if ( n > 0) {
            return sumRecursion(n-1) + n;
        }

        return -1;
    }

    //O(1)
    static int sum(int n) {
        return n*(n+1)/2;
    }

    //O(n)
    static int sumIterative(int n) {
        int i, s = 0;
        for (i = 1; i<= n; i++) {
            s = s + i;
        }
        return s;
    }
}
