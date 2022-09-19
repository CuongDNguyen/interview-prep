//5*4*3*2*1

import java.util.Comparator;
import java.util.PriorityQueue;

public class FactorialOfANumber {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        test();
    }

    static int factorial(int n) {
        if ( n == 0) {
            return 1;
        } else {
            return factorial(n-1) * n;
        }
    }

    static void test() {
        PriorityQueue<Integer> pqueue = new PriorityQueue();
        pqueue.add(1);
        pqueue.add(5);
        pqueue.add(3);
        pqueue.add(7);
        pqueue.add(6);

        while (!pqueue.isEmpty()) {
            System.out.println(pqueue.poll());
        }
    }
}
