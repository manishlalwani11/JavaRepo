package collections.sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] array = {11, 2, 8, 5, 3};

        for (int i = 0; i < array.length; i++) {
            System.out.println("Before sorting: " + array[i]);
        }

        int swap = 0;
        for (int i = 0; i < array.length; i++) {
            for (int y = 1; y < array.length - i; y++) {
                if (array[y - 1] > array[y]) {
                    swap = array[y - 1];
                    array[y - 1] = array[y];
                    array[y] = swap;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println("After sorting: " + array[i]);
        }


    }
}
