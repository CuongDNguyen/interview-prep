import java.util.HashMap;
import java.util.HashSet;

//remove duplicates from an unsorted linked list
/*
Example: 1 -> 5 -> 3 -> 7 -> 3 -> 2 -> 6 -> 2

Brute Force:
HashSet for each val in list
iterate through array to remove the nodes with the entries and repoint their .next to the next of deleted
 */
class RemoveDuplicatesLinkedList {
    public static void main(String[] args) {
        Node example = new Node(1);
        example.next = new Node(5);
                example.next.next = new Node(3);
                example.next.next.next = new Node(7);
                example.next.next.next.next = new Node(3);
                example.next.next.next.next.next = new Node(2);
                example.next.next.next.next.next.next = new Node(6);
                example.next.next.next.next.next.next.next = new Node(2);

       example.myAttempt(example);
       while (example != null) {
           System.out.println(example.val);
           example = example.next;
       }
    }

}

class Node {
    int val;
    Node next;
    HashSet<Integer> duplicateCheckSet;
    Node (int val) {
        this.val = val;
        this.next = null;
        this.duplicateCheckSet = new HashSet<>();
    }

    void myAttempt(Node inputNode) {
        Node currentNode = inputNode;
        while (currentNode.next != null) {
            if (!this.duplicateCheckSet.add(currentNode.next.val)) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
    }
}
