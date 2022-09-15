//5*4*3*2*1

public class FactorialOfANumber {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    static int factorial(int n) {
        if ( n == 0) {
            return 1;
        } else {
            return factorial(n-1) * n;
        }
    }
}
