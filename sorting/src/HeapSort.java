
//Time o(nlogn)
//Space O(1) not stable

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] testArray = {6, 2, 5, 7, 10, 12, 25, 17};
        heapSort(testArray, testArray. length - 1);
        System.out.println(Arrays.toString(testArray));
    }
    static void heapify(int[] array, int sizeOfHeap, int rootNodeIndex) {

        int largest = rootNodeIndex;
        int left = 2 * rootNodeIndex + 1;
        int right = 2 * rootNodeIndex + 2;

        if (left < sizeOfHeap && array[left] > array[largest]) {
            largest = left;
        }

        if (right < sizeOfHeap && array[right] > array[largest]) {
            largest = right;
        }

        if (largest != rootNodeIndex) {
            int temp = array[rootNodeIndex];
            array[rootNodeIndex] = array[largest];
            array[largest] = temp;

            heapify(array, sizeOfHeap, largest);
        }
    }

    static void heapSort(int[] array, int sizeOfHeap) {
        for (int i = sizeOfHeap / 2; i >= 0; i--) {
            heapify(array, sizeOfHeap, i);
        }

        for (int i = sizeOfHeap; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }
}
