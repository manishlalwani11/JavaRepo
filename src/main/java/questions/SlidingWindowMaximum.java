package questions;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
   HARD - https://leetcode.com/problems/sliding-window-maximum/description/

You are given an array of integers nums, there is a sliding window of size k which is moving
from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.
Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = getMaxFromSlidingWindow(nums, k); //TODO - To be optimised for large inputs
        for (int n : res) {
            System.out.println(n);
        }

    }

    //  1, 3, -1, -3, 5, 3, 6, 7
    private static int[] getMaxFromSlidingWindow(int[] nums,
                                                 int k) {
        int[] res = new int[nums.length - k + 1];
        int i = 0;
        int j = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (j = 0; j <= k - 2; j++) {
            pq.offer(nums[j]);
        }

        while (i < nums.length && j < nums.length) {
            pq.offer(nums[j]);
            j++;

            if (pq.size() == k && !pq.isEmpty()) {
                res[i] = pq.peek();
                pq.remove(nums[i]);
                i++;
            }
        }

        return res;
    }
}
