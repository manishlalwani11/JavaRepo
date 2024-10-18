package questions;

public class LogDataStream {
    public static void main(String[] args) {
        // TODO:: Binary Search complexity log(n)


        // log data -> Stream

        // [1,2,3,4,8,10]  => 3-10 =


        // [1,2,3,4,4,4,8,10]   => 4-10
        //        Left           right
        // First occurrence of 4 t1 ==> logn

        // case 7 - 10

        // First app => Find 3 ==> 1,2,3,4,8,10 using binary search ==> Offset

        // second, Find 10 => sub array => (Offset + 1 till arr.length -1) = [4,8,10]  ==> Offset of 10

        // Read data from offset 2 to 6

        int[] nums = new int[]{1, 2, 3, 3, 4, 4, 4, 8, 10};


        //1,2,3,4,4,4,8,10
        //      |

        int minRange = 3;
        int maxRange = 10;

        int minRangeOffset = getOffsetOfMinRange(nums, minRange);
        int[] maxRangeArr = splitArray(nums, minRangeOffset);

        int maxRangeOffset = getOffsetOfMinRange(maxRangeArr, maxRange);

    }

    private static int[] splitArray(int[] nums,
                                    int minRangeOffset) {
        int[] resArr = new int[nums.length - minRangeOffset + 1];
        for (int i = minRangeOffset + 1; i < nums.length; i++) {
            resArr[i] = nums[i];
        }

        return resArr;
    }

    private static int getOffsetOfMinRange(int[] nums,
                                           int val) {
        // val = 3
        // 1, 2, 3, 3, 4, 4, 4, 4, 4, 4, 8, 10
        // |                 M              |

        int left = 0;
        int right = nums.length - 1;
        int result = 0;

        /*while (left <= right) {
            int mid = (left + (right - left)) / 2;

            if (nums[mid] == val) {
                result = mid;
                left = mid - 1;
            } else if (nums[mid] < val) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }*/

        while (left <= right) {
            int mid = (left + right) /2 ;

            if(nums[mid] == val) {
                return mid;
            } else if (nums[mid] < val) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }


    /*

       Given schema: resquester_id, accepeter_id, accepted_date
       Sql for giving the Id who has max friends and its counts

        1, 2, 1st July
        1, 3, 2nd July
        2, 3, 1st July
        3, 4, 2nd July


       Select requester_id, count(distinct(accepeter_id)) as count from table group by resquester_id, accepeter_id order by count desc limit 1;
        o/p:
            count
         1 2
         3 1

         + JOIN on Key
       Select accepeter_id, count(distinct(requester_id)) as count from table group by resquester_id, accepeter_id
       3 2
       4 1
       2 1

       order by count desc limit 1

        can be optimised using union



     */
}
