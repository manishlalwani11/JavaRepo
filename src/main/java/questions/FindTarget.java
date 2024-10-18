package questions;

import java.awt.*;
import java.util.ArrayList;

/*
    Input list = [1, 4,5, 6,9] output=[1,5,10,16,25]
 */
public class FindTarget {
    public static void main(String[] args) {

        int[] nums = new int[]{1, 4, 5, 6, 9};
        int[] output = runningTotal(nums);

        for (int num : output) {
            System.out.println(num);
        }
    }

    private static int[] runningTotal(int[] nums) {
        int[] output = new int[nums.length];
        int currentSum = 0;

        // 100 --> 5 -> parallely

        // 1 million records => miniBatches => 1min * 1mill
        // => 1 min * (1mill / no. of batches)

        // 1 4 9
        // 6 5

        /*List<Integer> list = new ArrayList<>();

        list.sublist() ==>List<List<Integer>> listOFlist ()


        list.stream.par.foreach({x ->
                currentSum += x;
        output[i] = currentSum;
        }
    }


        )


                )

    Executoserive(100)

       for(
    List<Integer> batch:listOFlist)

    {

        () -> CompleteFutre(batch) {
        // 1 5 14
        // output

        // 6 5
        // 6 11
        // output
    }


        future1
                future2


        future3


                = future1.get()
        future2.get()

        CombinedFutr(future1, future2)

        future.allOf
        List<Result> resultList = future.get()

        resultList


    }


        for(
    int i = 0;
    i<nums.length;i++)

    {
        currentSum += nums[i];
        output[i] = currentSum;
    }

        return output;
}*/

        return null;
    }
}
