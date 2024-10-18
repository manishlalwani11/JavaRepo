package questions;

/* EASY

https://leetcode.com/problems/sort-array-by-parity/description/
Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
Return any array that satisfies this condition.

Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
Example 2:

Input: nums = [0]
Output: [0]

Constraints:
1 <= nums.length <= 5000
0 <= nums[i] <= 5000

*/

public class SortArrayByParity {
    public static void main(String[] args) {

        int[] nums = new int[]{3, 1, 2, 4};
        int[] res = sortArrByParity(nums);

        for (int n : res) {
            System.out.println(n);
        }
    }

    private static int[] sortArrByParity(int[] nums) {

        int[] res = new int[nums.length];
        int i = 0;  // pointer 1
        int j = nums.length - 1; // pointer 2
        for (int n : nums) {
            if (n % 2 == 0) {
                res[i] = n;
                i++;
            } else {
                res[j] = n;
                j--;
            }
        }

        return res;
    }
}
