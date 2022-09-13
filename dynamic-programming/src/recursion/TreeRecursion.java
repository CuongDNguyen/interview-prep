package recursion;

//Call itself more than one time, it is a tree recursion
public class TreeRecursion {

    public static void main(String[] args) {
        fun(3);
    }

    static void fun(int n) {
        if ( n > 0) {
            System.out.println(n);
            fun (n-1);
            fun (n-1);
        }
    }
}
