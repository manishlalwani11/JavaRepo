package practice;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class Test1 {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {


        Constructor<Person> constructor = Person.class.getConstructor();
        Person newPerson = constructor.newInstance();
        newPerson.setAge(1);


        int[] inputArray = new int[] {5,1,4,8};

         int[] ints = twoSum(inputArray, 9);

        System.out.println("result: " + ints);
    }

    private static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];

        for (int x = 0; x <= nums.length-1; x++) {

            if(x+1 == nums.length){
                break;
            }

            if (nums[x] + nums[x+1] == target) {
                result[0] = x;
                result[1] = x+1;
                break;
            }

        }

        return result;
    }

}
