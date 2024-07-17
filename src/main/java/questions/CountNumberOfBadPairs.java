package questions;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/count-number-of-bad-pairs/

You are given a 0-indexed integer array nums. A pair of indices (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i].

Return the total number of bad pairs in nums.

Example 1:

Input: nums = [4,1,3,3]
Output: 5
Explanation: The pair (0, 1) is a bad pair since 1 - 0 != 1 - 4.
The pair (0, 2) is a bad pair since 2 - 0 != 3 - 4, 2 != -1.
The pair (0, 3) is a bad pair since 3 - 0 != 3 - 4, 3 != -1.
The pair (1, 2) is a bad pair since 2 - 1 != 3 - 1, 1 != 2.
The pair (2, 3) is a bad pair since 3 - 2 != 3 - 3, 1 != 0.
There are a total of 5 bad pairs, so we return 5.
Example 2:

Input: nums = [1,2,3,4,5]
Output: 0
Explanation: There are no bad pairs.


Constraints:

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

Solution:
bad pair => i < j and j - i != nums[j] - nums[i] // This will require O(n^2) to evaluate as it has i and j on both sides
         => j - nums[j] != i - nums[i]   // re-arranged the equation
Good pair=> j - nums[j] == i - nums[i]

Thus bad pair = Total pairs - Good pair

 */
public class CountNumberOfBadPairs {
    public static void main(String[] args) {

        int[] nums = new int[]{4, 1, 3, 3};
        long badPairs = getBadPairs(nums);
        System.out.println("badPairs: " + badPairs);
    }

    /*private static int getBadPairs(int[] nums) {
        int totalPairs = (nums.length * (nums.length - 1)) / 2;   // nC2 = n*n-1/2
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currDiff = i - nums[i];
            map.put(currDiff, map.getOrDefault(currDiff, 0) + 1);
            totalPairs -= map.get(currDiff); // reducing the good pair to get bad pairs
        }
        return totalPairs;
    }*/

    private static long getBadPairs(int[] nums) {

        long ans = 0;
        Map<Integer, Long> count = new HashMap<>(); // (nums[i] - i)

        for (int i = 0; i < nums.length; ++i) {
            //     count[nums[i] - i] := the number of good pairs
            // i - count[nums[i] - i] := the number of bad pairs
            ans += i - count.getOrDefault(nums[i] - i, 0L);
            count.merge(nums[i] - i, 1L, Long::sum);
        }

        return ans;
    }
}
