/*
MergeSort(arr[], l,  r)
If r > l

Find the middle point to divide the array into two halves:
middle m = l + (r – l)/2
Call mergeSort for first half:
Call mergeSort(arr, l, m)
Call mergeSort for second half:
Call mergeSort(arr, m + 1, r)
Merge the two halves sorted in steps 2 and 3:
Call merge(arr, l, m, r)
 */

import java.util.Arrays;

//Onlogn time
//On space
class MergeSort {

    public static void main(String[] args) {
        int[] testArray = {6, 2, 5, 7, 10, 12, 25, 17};
        mergeSort(testArray, 0, testArray.length - 1);
        System.out.println(Arrays.toString(testArray));
    }

    static void mergeSort (int[] array, int start, int end) {
        int lengthArray = array.length;
        if ( lengthArray < 2 ) {
            return;
        }

        if ( start < end ) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1,  end);
            merge(array, start, mid, end);
        }
    }

    static void merge(int[] array, int start, int mid, int end) {
        int lengthOfLeftArray = mid - start + 1;
        int lengthOfRightArray = end - mid;

        int[] L = new int[lengthOfLeftArray];
        int[] R = new int[lengthOfRightArray];

        for (int i = 0 ; i < lengthOfLeftArray; i++) {
            L[i] = array[start + i];
        }

        for (int j = 0;j < lengthOfRightArray; j++) {
            R[j] = array[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = start;

        while (i < lengthOfLeftArray && j < lengthOfRightArray ) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < lengthOfLeftArray) {
            array[k] = L[i];
            i++;
            k++;
        }

        while ( j < lengthOfRightArray) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
}
