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

class MergeSort {
    public static void main(String[] args) {

        List<Integer> testNums = new ArrayList<>(){{1, 2, ,5 , 1, 9, 4, 3, 12, 21}};
    }

    void mergeSort(List<Integer> nums) {


    }

    private void mergeSort(List<Integer> nums, int left, int right) {
        if (right > left) {
            int middle = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);

            //merge both halfs
        }
    }
}
