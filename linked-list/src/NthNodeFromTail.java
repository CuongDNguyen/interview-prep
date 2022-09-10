package src;

import java.util.HashMap;

/*
Given a Linked List and a number N,
 write a function that returns the
 value at the Nth node from the end of the Linked List.

Example:
Input: 35 -> 15 -> 4 -> 20, N = 4
Output: 35

Brute Force Solution;
Iterate through linked list, adding index as key in hashmap and value as value in hashmap
Find tail index (where next = null)
Tail index - number N in hash map should be value of the Nth node

HashMap O(n) Space O(n)
 */
public class NthNodeFromTail {
    public static void main(String[] args) {
        Node test = new Node(1);
        test.next = new Node(2);
        test.next.next = new Node(3);
        test.next.next.next = new Node(4);
        System.out.println(myAttempt(test, 1));
    }

    static int myAttempt(Node inputNode, int n) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int tailIndex = 0;
        int i = 1;
        while (inputNode != null) {
            hashMap.put(i, inputNode.val);
            if (inputNode.next == null) {
                tailIndex = i;
            }
            i++;
            inputNode = inputNode.next;
        }

        int nthNodeIndex = tailIndex - n + 1;
        return hashMap.get(nthNodeIndex);
    }
}
