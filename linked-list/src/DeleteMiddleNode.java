package src;

//Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
//the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
//that node.

/*

 */
public class DeleteMiddleNode {
    public static void main(String[] args) {
        Node test = new Node(1);
        test.next = new Node(2);
        Node middleNode = test.next.next = new Node(3);
        test.next.next.next = new Node(4);
        test.next.next.next.next = new Node(5);
    }

    static void deleteMiddleNodeMyAttempt(Node inputNode) {

    }
}
