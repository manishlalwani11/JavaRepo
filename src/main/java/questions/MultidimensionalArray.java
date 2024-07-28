package questions;

public class MultidimensionalArray {
    public static void main(String[] args) {

        TwoDArray();

        ThreeDArray();

    }

    private static void ThreeDArray() {
        // create a 3d array
        int[][][] array3d = {
                {
                        {1, -2, 3},
                        {2, 3, 4}
                },
                {
                        {-4, -5, 6, 9},
                        {1},
                        {2, 3}
                }
        };

        // for.each loop to iterate through elements of 3d array
        for (int[][] array2D : array3d) {
            for (int[] array1D : array2D) {
                for (int item : array1D) {
                    System.out.println(item);
                }
            }
        }
    }

    private static void TwoDArray() {
        // create a 2d Array

        int[][] arr = {
                {1, -2, 3},
                {4, -5, 6, 9},
                {10, 2, 5}
        };

        // TODO First approach to loop
        // first for...each loop access the individual array
        // inside the 2d array
        for (int[] innerArray : arr) {
            // second for...each loop access each element inside the row
            for (int data : innerArray) {
                System.out.println(data);
            }
        }

        // TODO 2nd way to loop
        for (int i = 0; i < arr.length; i++) {
            // Length of rows or first array
            System.out.println("length: " + arr[i].length);
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(i + "," + j + " = " + arr[i][j]);
            }
        }
    }

}

