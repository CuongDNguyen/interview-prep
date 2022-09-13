package recursion;

//Function does not have to perform any operation at the time of calling
//Only processing at the time of returning
public class HeadRecursion {
    public static void main(String[] args) {
        fun(5);
    }

    static void fun(int n) {
        if ( n > 0) {
            fun ( n - 1);
            System.out.println(n);
        }
    }
}
