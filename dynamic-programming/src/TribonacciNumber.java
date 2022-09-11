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
        int first=0,second=1,third=1;
        // here first,second and third are the previous three elements
        if(n<2)
            return n;
        // if n=0 or n=1 then the tribonacci number is n itself
        // else for loop will be executed
        for(int i=3;i<=n;i++)
        {
            int newElement=first+second+third;
            first=second;
            second=third;
            third=newElement;
        }
        //If n=2 then the for loop is not executed and the initial value of the
        //variable third is returned which is 1
        return third;
        // returning the last element
    }
}
