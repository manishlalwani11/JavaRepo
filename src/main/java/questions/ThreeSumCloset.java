package questions;

import java.util.*;

public class ThreeSumCloset {
    public static void main(String[] args) {

        int[] nums = new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5};

        System.out.println(getListOfTriplets(nums, -2));

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
            System.out.println("Fixing: " + nums[x]);
            i = x + 1;
            j = nums.length - 1;
            while (i < j) {
                sum = nums[x] + nums[i] + nums[j];

                if (sum == target) {
                    threeSumIntegers.add(Arrays.asList(nums[x], nums[i], nums[j]));
                    // if existing diff is greater than new diff between target and sum, then replace
                    if (checkIfMapIsEmpty(target, map, sum) || checkAndReplaceInMap(target, map, sum)) {
                        map.clear();
                        map.put(Math.abs(target - sum), sum);
                    }
                    i++;
                    j--;
                } else if (sum < target) {
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
           // map.put(Math.abs(target - sum), sum);
            return true;
        }

        return false;
    }

    private static boolean checkAndReplaceInMap(int target,
                                                HashMap<Integer, Integer> map,
                                                int sum) {
        return !map.keySet().isEmpty() && (map.keySet().stream().findFirst().get() > Math.abs(target - sum));
    }

}
