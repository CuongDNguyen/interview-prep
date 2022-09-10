import java.util.ArrayList;
import java.util.Objects;

public class HashTable<K, V> {

    private ArrayList<HashNode<K, V>> bucketArrayList;
    private int numBuckets;
    private int size;

    HashTable() {
        bucketArrayList = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        for (int i = 0; i < numBuckets; i++) {
            bucketArrayList.add(null);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int createHashcode(K key) {
        return Objects.hashCode(key);
    }

    private int getBucketIndex(K key) {
        int hashcodeTemp = createHashcode(key);
        int index = hashcodeTemp % numBuckets;
        index = index < 0 ? index * -1 : index; //negative hashcode key
        return index;
    }

    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        int hashCode = createHashcode(key);
        HashNode<K, V> head = bucketArrayList.get(bucketIndex);

        HashNode<K, V> prev = null;
        while( head != null) {
            if (head.key.equals(key) && hashCode == head.hashcode) {
                break;
            }

            prev = head;
            head = head.next;
        }
        if (head == null) {
            return null;
        }

        size--;

        if (prev != null) {
            prev.next = head.next;
        } else {
            bucketArrayList.set(bucketIndex, head.next);
        }

        return head.value;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        int hashcode = createHashcode(key);
        HashNode<K, V> head = bucketArrayList.get(bucketIndex);

        while(head != null) {
            if (head.key.equals(key) && head.hashcode == hashcode) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public void add(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        int hashcode = createHashcode(key);
        HashNode<K, V> head = bucketArrayList.get(bucketIndex);

        while (head != null) {
            if (head.key.equals(key) && head.hashcode == hashcode) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = bucketArrayList.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<>(key, value, hashcode);
        newNode.next = head;
        bucketArrayList.set(bucketIndex, newNode);

        //if load factor goes beyond threshold, double bucket size
        if ((1.0 * size) / numBuckets >= 0.7) {
            ArrayList<HashNode<K, V>> temp = bucketArrayList;
            bucketArrayList = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++) {
                bucketArrayList.add(null);
            }

            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

}

class HashNode<K, V> {
    K key;
    V value;
    final int hashcode;
    HashNode<K, V> next;

    public HashNode(K key, V value, int hashcode) {
        this.key = key;
        this.value = value;
        this.hashcode = hashcode;
    }
}
