package questions;

/**
 * https://leetcode.com/problems/lexicographically-smallest-string-after-a-swap/description/
 *
 * Given a string s containing only digits, return the
 * lexicographically smallest string
 *  that can be obtained after swapping adjacent digits in s with the same parity at most once.
 *
 * Digits have the same parity if both are odd or both are even. For example, 5 and 9, as well as 2 and 4, have the same parity, while 6 and 9 do not.
 *
 * Example 1:
 *
 * Input: s = "45320"
 *
 * Output: "43520"
 *
 * Explanation:
 *
 * s[1] == '5' and s[2] == '3' both have the same parity, and swapping them results in the lexicographically smallest string.
 *
 * Example 2:
 *
 * Input: s = "001"
 *
 * Output: "001"
 *
 * Explanation:
 *
 * There is no need to perform a swap because s is already the lexicographically smallest.
 *
 *
 * Constraints:
 *
 * 2 <= s.length <= 100
 * s consists only of digits.
 */
public class LexicographicallySmallestStringAfterASwap {

    public static void main(String[] args) {

        String s = "45320";
        String smallestString = getSmallestStringViaCharArray(s);
        System.out.println("result string: "+ smallestString);

    }

    public static String getSmallestString(String s) {
        StringBuilder resultString = new StringBuilder(s);
        boolean isSwapped = false;

        for (int i = 0; i < s.length() - 1; i++) {
            int curr = Character.getNumericValue(s.charAt(i));
            int next = Character.getNumericValue(s.charAt(i + 1));

            if ((curr % 2 == next % 2) && !isSwapped) {
                if (curr > next) {
                    // Perform swap
                    resultString.setCharAt(i, s.charAt(i + 1));
                    resultString.setCharAt(i + 1, s.charAt(i));
                    isSwapped = true;
                }
            }
        }

        return resultString.toString();
    }

    public static String getSmallestStringViaCharArray(String s) {
        char[] charArray = s.toCharArray();
        boolean isSwapped = false;
        for (int i = 0; i < charArray.length - 1; i++) {
            int curr = Character.getNumericValue(charArray[i]);
            int next = Character.getNumericValue(charArray[i + 1]);

            if ((curr % 2 == next % 2) & !isSwapped) {

                if (curr > next) { // then swap
                    char temp = charArray[i];
                    charArray[i] = charArray[i + 1];
                    charArray[i + 1] = temp;
                    isSwapped = true;
                }
            }
        }

        return new String(charArray);
    }

}
