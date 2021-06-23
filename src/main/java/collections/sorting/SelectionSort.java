package collections.sorting;

public class SelectionSort {
    public static void main(String[] args) {

        int[] array = {11, 2, 8, 5, 3};

        for (int i = 0; i < array.length; i++) {
            System.out.println("Before sorting: " + array[i]);
        }

        int smallestNumIndex = 0;
        int smallestNum = 0;

        for (int i = 0; i < array.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[index]){
                    index = j;//searching for lowest index
                }
            }
            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }


        for (int i = 0; i < array.length; i++) {
            System.out.println("After sorting: " + array[i]);
        }

    }
}
