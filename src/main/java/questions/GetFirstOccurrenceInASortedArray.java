package questions;

public class GetFirstOccurrenceInASortedArray {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 3, 4, 4, 4, 8, 10};
        int valueToSearch = 3;

        int offset = getFirstOccurrenceInASortedArray(nums, valueToSearch);
        System.out.println(offset);
    }

    private static int getFirstOccurrenceInASortedArray(int[] nums,
                                                        int val) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1; // default if val is not present

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == val) {
                result = mid;
                right = mid - 1;
            } else if (nums[mid] > val) {
                right = mid - 1;
            } else {
                left = left + 1;
            }
        }

        return result;
    }
}
