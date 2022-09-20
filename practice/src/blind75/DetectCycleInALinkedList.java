package blind75;

/*
Given head, the head of a linked list, determine
if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node
in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list.
Otherwise, return false.

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list,
where the tail connects to the 1st node (0-indexed).
 */

public class DetectCycleInALinkedList {
    static class Node {
        int val;
        Node next;
        Node (int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(0);
        head.next.next.next = new Node (-4);
        System.out.println(hasCycle(head));
    }

    static boolean hasCycle(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }
}
