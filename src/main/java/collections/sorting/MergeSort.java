package collections.sorting;

import collections.arrays.Merge2SortedArray;

/**
 *  @Merge-sort is more efficient and works faster than quick sort in case of larger array size or datasets.
 *  whereas Quick sort is more efficient and works faster than merge sort in case of smaller array size or datasets.
 *
 *  The time complexity of merge sort is always O(n log n),
 *  while the time complexity of quicksort varies between O(n log n) in the best case to O(n2) in the worst case.
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {5, 2, 7, 11, 3, 1};

        System.out.println("printing input array:");
        for (int i : arr) {
            System.out.println(i);
        }

        int[] result = megeSort(arr, 0, arr.length - 1);

        System.out.println("printing result array:");
        for (int res : result) {
            System.out.println(res);
        }
    }

    private static int[] megeSort(int[] arr, int low, int high) {

        if (low == high) {
            int[] baseArray = new int[1];
            baseArray[0] = arr[low];
            return baseArray;
        }

        //calculating mid element
        int mid = (low + high) / 2;

        int[] arr1 = megeSort(arr, low, mid);
        int[] arr2 = megeSort(arr, mid + 1, high);

        //merge 2 sorted arrays

        return Merge2SortedArray.merge2SortedArrays(arr1, arr2);

    }

}
