package questions;

import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 * <p>
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 * <p>
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class ThreeSum {
    public static void main(String[] args) {

        int[] nums = new int[]{-1, 2, 1, -4};

        System.out.println(getListOfTriplets(nums, 1));

    }

    private static int getListOfTriplets(int[] nums,
                                         int target) {

        /*if (Objects.isNull(nums) && nums.length < 3) {
            return Collections.EMPTY_LIST;
        }*/

        Set<List<Integer>> threeSumIntegers = new HashSet<>();
        int i;
        int j;
        int sum;
        HashMap<Integer, Integer> map = new HashMap<>();

        Arrays.sort(nums);

        for (int x = 0; x <= nums.length - 3; x++) {
            System.out.println(nums[x]);
            i = x + 1;
            j = nums.length - 1;
            while (i < j) {
                sum = nums[x] + nums[i] + nums[j];

                if (sum == 0) {
                    threeSumIntegers.add(Arrays.asList(nums[x], nums[i], nums[j]));
                    // if existing diff is greater than new diff between target and sum, then replace
                    if (checkIfMapIsEmpty(target, map, sum) || checkAndReplaceInMap(target, map, sum)) {
                        map.clear();
                        map.put(Math.abs(target - sum), sum);
                    }
                    i++;
                    j--;
                } else if (sum < 0) {
                    if (checkIfMapIsEmpty(target, map, sum) || checkAndReplaceInMap(target, map, sum)) {
                        map.clear();
                        map.put(Math.abs(target - sum), sum);
                    }
                    i++;
                } else {
                    if (checkIfMapIsEmpty(target, map, sum) || checkAndReplaceInMap(target, map, sum)) {
                        map.clear();
                        map.put(Math.abs(target - sum), sum);
                    }
                    j--;  // in case sum > 0
                }
            }
        }

        return map.values().stream().findFirst().get();

    }

    private static boolean checkIfMapIsEmpty(int target,
                                             HashMap<Integer, Integer> map,
                                             int sum) {
        if (map.isEmpty()) {
            map.put(Math.abs(target - sum), sum);
            return true;
        }

        return false;
    }

    private static boolean checkAndReplaceInMap(int target,
                                                HashMap<Integer, Integer> map,
                                                int sum) {
        return !map.keySet().isEmpty() && (map.keySet().stream().findFirst().get() > Math.abs(target - sum));
    }

    private static Set<Integer> getNumswithSum(int[] nums,
                                               int sum,
                                               int arrStart,
                                               Map<Integer, Integer> map) {

        HashSet<Integer> twoSumIntegers = new HashSet<>();

        for (int j = arrStart; j < nums.length; j++) {

            if (map.containsKey(sum - nums[j])) {
                twoSumIntegers.add(nums[j]);
                twoSumIntegers.add(sum - nums[j]);
                return twoSumIntegers;

            } else {
                map.put(nums[j], j);
            }
        }
        return Collections.EMPTY_SET;
    }
}
