//(m)^n
/*
m == 0 1
m > 0 pow(m, n-1) * m
 */
public class Exponential {
    public static void main(String[] args) {
        System.out.println(power(2, 5));

    }
    static int power(int m, int n) {
        if (n == 0) {
            return 1;
        } else {
            return power(m,n - 1) * m;

        }
    }
}
