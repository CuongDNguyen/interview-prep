package recursion;

//If recursive function is calling itself in the last statement
//At returning time, no processing, if + n is added, not tail
//Loop is more efficient in terms of space, space O(1) compared to O(n)
public class TailRecursion {
    public static void main(String[] args) {
        fun(5);
    }

    static void fun(int n) {
        if (n > 0) {
            System.out.println(n);
            fun(n - 1);
        }
    }
}
