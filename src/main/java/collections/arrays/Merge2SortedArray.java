package collections.arrays;

/**
 * Given 2 sorted array merge them into a single array.
 */

public class Merge2SortedArray {
    public static void main(String[] args) {

        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {1, 2, 4, 6, 8};

        System.out.println("printing first array:");
        for (int i : arr1) {
            System.out.println(i);
        }

        System.out.println("printing second array:");
        for (int i : arr2) {
            System.out.println(i);
        }

        int[] result = merge2SortedArrays(arr1, arr2);

        System.out.println("printing result array:");
        for (int res : result) {
            System.out.println(res);
        }

    }

    public static int[] merge2SortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i++;
                k++;
            } else {
                result[k] = arr2[j];
                j++;
                k++;
            }
        }

        while (i < arr1.length) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arr2.length) {
            result[k] = arr2[j];
            j++;
            k++;
        }
        return result;
    }
}
