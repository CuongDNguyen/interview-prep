package blind75;

import java.util.Stack;

/*
Given the head of a singly linked list,
 reverse the list, and return the reversed list.


 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        reverseLinkedList(head);

    }

    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    static void reverseLinkedList(Node head) {
        Stack<Node> stack = new Stack();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().val);
        }
    }
}
