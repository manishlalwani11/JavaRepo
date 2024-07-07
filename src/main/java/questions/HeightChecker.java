package questions;

import java.util.Arrays;

/**
 * Code
 * Testcase
 * Test Result
 * Test Result
 * 1051. Height Checker
 * Easy
 * Topics
 * Companies
 * Hint
 * A school is trying to take an annual photo of all the students. The students are asked to stand in a single file line in non-decreasing order by height. Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.
 * <p>
 * You are given an integer array heights representing the current order that the students are standing in. Each heights[i] is the height of the ith student in line (0-indexed).
 * <p>
 * Return the number of indices where heights[i] != expected[i].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: heights = [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * heights:  [1,1,4,2,1,3]
 * expected: [1,1,1,2,3,4]
 * Indices 2, 4, and 5 do not match.
 * Example 2:
 * <p>
 * Input: heights = [5,1,2,3,4]
 * Output: 5
 * Explanation:
 * heights:  [5,1,2,3,4]
 * expected: [1,2,3,4,5]
 * All indices do not match.
 * Example 3:
 * <p>
 * Input: heights = [1,2,3,4,5]
 * Output: 0
 * Explanation:
 * heights:  [1,2,3,4,5]
 * expected: [1,2,3,4,5]
 * All indices match.
 *
 *
 * Constraints:
 *
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 */

public class HeightChecker {
    public static void main(String[] args) {

        int[] heights = new int[]{1, 1, 4, 2, 1, 3};

        int result = heightCheckerOptimised(heights);

        System.out.println("result is: " + result);

    }
    // Complexity - O(nlogn)
    // space - O(n)
    private static int heightChecker(int[] heights) {
        int res = 0;
        int[] clone = heights.clone(); // O(nlogn) sorting time complexity
        Arrays.sort(clone);

        for (int i = 0; i < heights.length; i++) {
            if (clone[i] != heights[i]) {
                res++;
            }
        }
        return res;
    }

    private static int heightCheckerOptimised(int[] heights) {
        int res = 0;
        int[] freq = new int[101]; // as there is a constraint: 1 <= heights[i] <= 100
        int currHeight = 0;

        for (int height : heights) {
            freq[height]++;
        }

        /* for (int f : freq) {
            System.out.println(f);
        }*/

        // iterate height array
        for (int i = 0; i < heights.length; i++) {
            while (freq[currHeight] == 0) { // if the current height is 0 in the freq[currHeight] we can skip it as nobody is having that height
                currHeight++;
            }

            if(currHeight != heights[i]) {   // since we have already counted how many people are there with the same height, then we can find the ones which are not standing in place.
                res++;
            }

            freq[currHeight]--;  // decrease the value of current height as we have already counted/considered that person once.
        }

        return res;
    }


}
