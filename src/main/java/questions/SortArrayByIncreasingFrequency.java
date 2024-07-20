package questions;

import java.util.*;

/**
 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
 * <p>
 * Return the sorted array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2,2,2,3]
 * Output: [3,1,1,2,2,2]
 * Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
 * Example 2:
 * <p>
 * Input: nums = [2,3,1,3,2]
 * Output: [1,3,3,2,2]
 * Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
 * Example 3:
 * <p>
 * Input: nums = [-1,1,-6,4,5,-6,1,4,1]
 * Output: [5,-1,4,4,-6,-6,1,1,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */
public class SortArrayByIncreasingFrequency {

    public static void main(String[] args) {

        int[] nums = new int[]{2,3,1,3,2};
        int[] res = frequencySort2ndWay(nums);

        for (int r : res) {
            System.out.println(r);
        }
    }

    private static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int n : nums) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>(freqMap.keySet());

        // Sorting using comparator
        list.sort((a, b) -> (Objects.equals(freqMap.get(a), freqMap.get(b)) ? b - a : freqMap.get(a) - freqMap.get(b)));

        int[] res = new int[nums.length];
        int index = 0;
        for (int num : list) {
            // check if freq not null
            for (int y = 0; y < freqMap.get(num); y++) {
                res[index++] = num;
            }
        }

        return res;
    }

    public static int[] frequencySort2ndWay (int[] nums) {

        /*
        -100 <= nums[i] <= 100
        The formula to calculate the number of integers between two inclusive bounds a and  b is b−a+1.
        => 100 -(-100) + 1 => 201
        -100 to -1   -1 -(-100) + 1 => -1 + 100 + 1 => 100
        1 to 100 => 100 - 1 + 1 => 100
        also we need to consider 0 => 1
        therefore => Total = 201
         */
        int[] freq = new int[201];  // taking 201 to accomodate nums from -100 to 100; for 100 we would need 200th cell i.e. from 0th to 200th => total 201 as arrays is 0-indexed
        ArrayList<Integer> list = new ArrayList<>();
        // 2,3,1,3,2
        for (int num : nums) {
            list.add(num);
            freq[num + 100] = freq[num + 100] + 1;  // adding 100 to accommodate frequencies of -ve numbers.
        }

        // freq arr
        //  0 1 2 3,4,5,6,7,.........201
        // [0,1,2,2,0,0,0,0.... upto 201]

        // list
        // (2,3,1,3,2)
        list.sort((a, b) -> (freq[a + 100] == freq[b + 100]) ? b - a : freq[a + 100] - freq[b + 100]);

        int[] res = new int[nums.length];
        int i =0;
        for (int num : list) {
            res[i++] = num;
        }

        return res;

    }


}
