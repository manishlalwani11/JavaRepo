package questions;

import collections.heap.MinimumHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 5, 7, 10, 4};
        int k = 3;

        int x = getKthLargestElement(nums, k);
        System.out.println(k + "th largest element is: " + x);
    }

    private static int getKthLargestElement(int[] nums,
                                            int k) {
        //PriorityQueue<Integer> pq = new PriorityQueue<>(k); //MIN HEAP -- By default pq implements MIN HEAP

        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder()); // MAX HEAP
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
