package questions;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]

Constraints:
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

import java.util.*;

public interface TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,-1};
        int k = 1;
        int[] res = getTopKFrequentElementsViaBucketSort(nums, k);

        for (int n : res) {
            System.out.println(n);
        }
    }

    // Complexity =>  //O(n) + O(mlogm)   ->> m is the unique nums
    static int[] getTopKFrequentElements(int[] nums,
                                         int k) {

        if (nums.length == 1) {
            return nums;
        }

        int[] resultarr = new int[k];

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int m : map.keySet()) {
            pq.offer(m);                  // Each insertion into the priority queue is O(log(m)),
            // so the overall complexity for this part is O(nlog(m)).
        }

        for (int x = 0; x < k; x++) {
            int num = pq.poll();
            resultarr[x] = num;
        }

        return resultarr;
    }

    private static int[] getTopKFrequentElementsViaBucketSort(int[] nums,
                                                              int k) {

        List<Integer>[] bucket = new ArrayList[nums.length + 1];  // it by default gets created with null !!
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[k];

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int n : map.keySet()) {
            if (bucket[map.get(n)] == null) {
                bucket[map.get(n)] = new ArrayList<>();
            }
            bucket[map.get(n)].add(n);
        }

        //        3    2    1
        // \__/ \__/ \__/ \__/ \__/ \__/ \__/ \__/ ..... items in buckets
        //   0   1    2    3     4   5    6    7   ..... frequencies

        // To get the top K frequent elements start counting from the end of the array

        int counter = 0;
        for (int i = nums.length; i >= 0 && counter < k; i--) {
            if (bucket[i] != null) {
                for (int n : bucket[i]) {
                    result[counter++] = n;
                }
            }
        }

        return result;

    }


}
