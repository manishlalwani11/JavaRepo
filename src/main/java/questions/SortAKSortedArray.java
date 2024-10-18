package questions;


import java.util.PriorityQueue;

/*
    K sorted Array also known as nearly sorted Array at times.
 */
public class SortAKSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        int[] res = sortArray(nums, k);

        for (int n : res) {
            System.out.println(n);
        }
    }

    private static int[] sortArray(int[] nums,
                                   int k) {
        int[] res = new int[nums.length];
        int i = 0, j = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (i <= nums.length - 1 && j <= nums.length - 1) {
            if (pq.size() < k) {
                pq.offer(nums[j]);
                j++;
                continue;
            }
            pq.offer(nums[j]);
            j++;

            if (pq.size() > k && !pq.isEmpty()) {
                res[i] = pq.poll();
                i++;
            }
        }

        while (!pq.isEmpty()) {
            res[i] = pq.poll();
            i++;
        }

        return res;
    }
}
