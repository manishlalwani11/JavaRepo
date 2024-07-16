package questions;

/**
 * https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/description/
 *
 * 2006. Count Number of Pairs With Absolute Difference K
 * Easy
 * Topics
 * Companies
 * Hint
 * Given an integer array nums and an integer k, return the number of pairs (i, j) where i < j such that |nums[i] - nums[j]| == k.
 *
 * The value of |x| is defined as:
 *
 * x if x >= 0.
 * -x if x < 0.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,1], k = 1
 * Output: 4
 * Explanation: The pairs with an absolute difference of 1 are:
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * Example 2:
 *
 * Input: nums = [1,3], k = 3
 * Output: 0
 * Explanation: There are no pairs with an absolute difference of 3.
 * Example 3:
 *
 * Input: nums = [3,2,1,5,4], k = 2
 * Output: 3
 * Explanation: The pairs with an absolute difference of 2 are:
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * 1 <= k <= 99
 *
 */
public class CountNumberOfPairsWithAbsoluteDifferenceK {

    /*
      [1,2,2,1]
      [0,2,2,0,0,0,0.....]

      3,2,1,5,4
      [0,1,1,1,1,1]
    */
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,4};
        int k_abs_diff = 2;

        int pairsWithAbsDiff = getPairsWithAbsDiff(nums, k_abs_diff);
        System.out.println("pairs:" + pairsWithAbsDiff);
    }

    private static int getPairsWithAbsDiff(int[] nums,
                                           int k) {
        int pairs = 0; // Pairs are combinations out no of elements are distance k in the freq array: 2C1 * 2C1 = 4
        int[] numsFreq = new int[201];

        for (int i = 0; i < nums.length; i++) {
            numsFreq[nums[i]]++;
        }

        for (int i = 0; i < numsFreq.length - k; i++) {
            pairs += numsFreq[i] * numsFreq[i + k];
        }

        return pairs;
    }
}
