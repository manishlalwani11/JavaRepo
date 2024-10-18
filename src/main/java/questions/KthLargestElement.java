package questions;

import collections.heap.MinimumHeap;
import javafx.util.Pair;

import java.util.Collections;
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
public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 5, 7, 10, 4};
        int k = 3;

        int x = getKthLargestElement(nums, k);
        System.out.println(k + "th largest element is: " + x);
    }

    private static int getKthLargestElement(int[] nums,
                                            int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k); //MIN HEAP -- By default pq implements MIN HEAP

        //PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder()); // MAX HEAP
        // Use max heap -> As at any time only 3 minimum elements will be there
        // and MAX element will always be popped out from the pq

        for (int n : nums) {
            pq.offer(n);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        return pq.poll();
    }
}
