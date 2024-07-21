package questions;

import java.util.PriorityQueue;

/*
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Constraints:

1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
 */
public class FindKthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;

        int res = findKthLargestUsingPriorityQueue(nums, k);
        System.out.println(res);
    }

    private static int findKthLargestUsingPriorityQueue(int[] nums,
                                                        int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int res = 0;
        for (int num : nums) {
            pq.offer(num);
        }
        int i = 0;
        while (!pq.isEmpty() && i < k) {
            res = pq.poll();
            i++;
        }
        return res;
    }
}
