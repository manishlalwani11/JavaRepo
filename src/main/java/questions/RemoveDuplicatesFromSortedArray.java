package questions;

/*
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums.
More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.



Example 1:

Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).


Constraints:

1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 */

import java.util.HashMap;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};

        int k = removeDuplicatesNew(nums);
        System.out.println("k is: " + k);

    }


    private static int removeDuplicatesNew(int[] nums) {
        // Take 2 pointers -> One to keep track of the new array
        // -> One to traverse the array

        int k = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);

        // 0, 0, 1, 1, 2, 3, 2, 3, 3

        for (int i = 1; i < nums.length; i++) {

            if (map.containsKey(nums[i]) && map.get(nums[i]) < 2) {
                map.put(nums[i], map.get(nums[i]) + 1);
                k++; // increase the pointer
                nums[k] = nums[i];
            } else if (nums[i] != nums[i - 1]) {
                k++;
                nums[k] = nums[i];
                map.clear();
                map.put(nums[i], 1);
            }

        }

        return k+1;
    }

/*
    private static int removeDuplicates(int[] nums) {
        int currentElement = nums[0];
        int frequency = 1;
        int count = 1;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);

        for (int i = 1; i < nums.length - 1; i++) {

            if (map.containsKey(nums[i]) && map.get(nums[i]) < 2) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else if (nums[i] != nums[i + 1]) {
                count += map.get(nums[i]) + 1;
                map.clear();
                map.put(nums[i], 1);
            }

            if (nums[i] == nums[i + 1]) {
                count = setCurrentElement(currentElement, map, frequency, count, nums[i], nums[i + 1]);
                //i++;
            } else if (nums[i] != nums[i + 1]) {
                count = setCurrentElement(currentElement, map, frequency, count, nums[i], nums[i + 1]);
                nums[i] = nums[i + 1];
                //i++;
            }
        }

        return count;
    }

    private static int setCurrentElement(int currentElement,
                                         HashMap<Integer, Integer> map,
                                         int frequency,
                                         int count,
                                         int num1,
                                         int numPlus1) {

        // check and assign val to current Element.
        // Input: nums = [1, 1, 1, 2, 2, 3]
        // f = 2
        // c = 4

        if (num1 == numPlus1 && map.containsKey(num1) && map.get(num1) < 2) {
            map.put(num1, map.get(num1) + 1);
            count++;
        } else if ((num1 != numPlus1)) {
            map.clear();
            map.put(numPlus1, 1);
            count++;
        }

        return count;
    }*/

}
