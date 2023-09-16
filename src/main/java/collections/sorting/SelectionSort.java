package collections.sorting;

/**
 * Time complexity O(n^2)
 */
public class SelectionSort {
    public static void main(String[] args) {

        int[] arr = {11, 2, 8, 5, 3};

        for (int k : arr) {
            System.out.println("Before sorting: " + k);
        }

        int smallestNumIndex = 0;
        int smallestNum = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            //default pointing to first element, as anyways will be compared to all the next ones.
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;//searching for lowest minIndex
                }
            }

            // swap with first element
            smallestNum = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = smallestNum;

        }


        for (int j : arr) {
            System.out.println("After sorting: " + j);
        }

    }
}
