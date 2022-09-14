package recursion;

public class NestedRecursion {

    public static void main(String[] args) {
        System.out.println(fun(1));
    }
    static int fun(int n) {
        if (n > 100) {
            return n- 10;
        } else {
            return fun(fun(n+11));
        }
    }
}
