package questions;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/best-sightseeing-pair/description/
You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.

The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.

Return the maximum score of a pair of sightseeing spots.

Example 1:
Input: values = [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11

Example 2:
Input: values = [1,2]
Output: 2

Constraints:

2 <= values.length <= 5 * 104
1 <= values[i] <= 1000
 */

public class BestSightseeingPair {
    public static void main(String[] args) {

        /*
          values[i] + values[j] + i - j
        = values[i] + i + values[j] -j
        = if we maximize values[i] + i && values[j] -j then score will automatically will be maximum
         */

        int[] values = new int[]{8, 1, 5, 2, 6};
        int sum = getMaxScoreSightseeingPair(values);
        System.out.println(sum);
    }

    private static int getMaxScoreSightseeingPair(int[] values) {
        int maxOfValueI = Integer.MIN_VALUE; //values[i] + i
        int maxOfValueJ = Integer.MIN_VALUE; //values[j] -j

        // TODO in a single loop

        for (int i = 0; i < values.length; i++) {
            if (values[i] + i > maxOfValueI) {
                maxOfValueI = values[i] + i;
            }
            if (values[i] - i > maxOfValueJ) {
                maxOfValueJ = values[i] - i;
            }
        }

        return maxOfValueI + maxOfValueJ;

    }
}
