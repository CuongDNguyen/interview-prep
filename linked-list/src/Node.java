package src;

import java.util.HashSet;

public class Node {
    public int val;
    public Node next;
    public HashSet<Integer> duplicateCheckSet;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.duplicateCheckSet = new HashSet<>();
    }

    public void myAttempt(Node inputNode) {
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
