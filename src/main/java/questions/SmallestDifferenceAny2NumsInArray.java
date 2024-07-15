package questions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.abs;

public class SmallestDifferenceAny2NumsInArray {

    /**
     *
     * Given a list/array of floats, write a function that returns the smallest distance
     * (positive difference abs(a - b) ) between any 2 numbers in the array.
     *
     * Example (e.g. [1, 2, -0.2, 2.1] → 0.1)

     * @param args
     */
    public static void main(String[] args) {

        double[] nums = new double[]{1, 2, -0.2d, 2.1d};
        double smallestDiff = getSmallestDiff(nums);
        System.out.println("diff:" + smallestDiff);

        double[] nums1 = new double[]{1, 1, -0.2d, 2.1d};
        double smallestDiff1 = getSmallestDiff(nums1);
        System.out.println("diff:" + smallestDiff1);

        double[] nums2 = new double[]{-2, -4, -0.2d, 2.1d};
        double smallestDiff2 = getSmallestDiff(nums2);
        System.out.println("diff:" + smallestDiff2);

        double[] nums3 = new double[]{-2, -4, 99, 100};
        double smallestDiff3 = getSmallestDiff(nums3);
        System.out.println("diff:" + smallestDiff3);

        double[] nums4 = new double[]{-2, -1, 0, 0};
        double smallestDiff4 = getSmallestDiff(nums4);
        System.out.println("diff:" + smallestDiff4);

        double[] nums5 = new double[]{-1, -2, -3, -4};
        double smallestDiff5 = getSmallestDiff(nums5);
        System.out.println("diff:" + smallestDiff5);

        double[] nums6 = new double[]{Double.MIN_VALUE, Double.MAX_VALUE};
        double smallestDiff6 = getSmallestDiff(nums6);
        System.out.println("diff:" + smallestDiff6);

        double[] nums7 = new double[]{1, 2, 3, 5};
        double smallestDiff7 = getSmallestDiff(nums7);
        System.out.println("diff:" + smallestDiff7);

        double[] nums8 = new double[]{};
        double smallestDiff8 = getSmallestDiff(nums8);
        System.out.println("diff:" + smallestDiff8);


    }

    private static double getSmallestDiff(double[] nums) {

        if (nums.length <= 1) {
            System.out.println("Enter at-least 2 nums");
        }

        double diff = Double.MAX_VALUE;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length -1; i++) {
            if (Double.MIN_VALUE < abs(nums[i + 1] - nums[i]) && abs(nums[i + 1] - nums[i]) < diff) {
                diff = abs(nums[i + 1] - nums[i]);
            }
        }

        return diff;
    }
}
