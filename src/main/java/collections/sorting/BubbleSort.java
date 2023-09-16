package collections.sorting;

/**
 * Time complexity O(n^2)
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] array = {11, 2, 8, 5, 3};

        for (int i = 0; i < array.length; i++) {
            System.out.println("Before sorting: " + array[i]);
        }

        int swap = 0;
        for (int i = 0; i < array.length; i++) {
            for (int y = 0; y < array.length - i -1; y++) {
                if (array[y] > array[y + 1]) {
                    swap = array[y];
                    array[y] = array[y + 1];
                    array[y + 1] = swap;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println("After sorting: " + array[i]);
        }


    }
}
