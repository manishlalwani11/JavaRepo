package collections.arrays;

public class ReverseIntegerSigned {

    /*
    Given a signed 32-bit integer x, return x with its digits reversed.
    If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
     */

    public static void main(String[] args) {

        int x = 2147483637;
        Integer reversedValue = getReversOfSignedInteger(x);

        System.out.println("reversed: " + reversedValue);



    }

    private static Integer getReversOfSignedInteger(int x) {
        long reversedValue = 0;
        while (x != 0){

            int mod = x % 10;
            x = x /10;

            if(reversedValue *10 > Integer.MAX_VALUE || reversedValue *10 < Integer.MIN_VALUE) {
                return 0;
            }

            reversedValue = reversedValue * 10 + mod;

        }

        return (int)reversedValue;
    }
}
