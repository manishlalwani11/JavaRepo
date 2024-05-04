package questions;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 15};

        System.out.println(getNumswithSum(nums, 9));

    }

    private static Set<Integer> getNumswithSum(int[] nums,
                                               int sum) {

        HashMap<Integer, Integer> map = new HashMap<>();

        HashSet<Integer> twoSumIntegers = new HashSet<>();

        for (int j = 0; j < nums.length; j++) {

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
