package questions;


import java.util.*;

/*
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.



Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.


Constraints:

1 <= s.length <= 5 * 10^5
s consists of uppercase and lowercase English letters and digits.
 */
public class SortCharactersByFrequency {

    public static void main(String[] args) {

        String s = "Aabb";
        String resString = sortCharacterByFrequencyViaPriorityQueue(s);
        System.out.println(resString);

    }


    private static String sortCharacterByFrequency(String s) {

        int[] freqArr = new int[123]; // since ASCII range for A-Z is 65-90 and for a-z is 97-122
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            int asciiVal = (int) (s.charAt(i));
            freqArr[asciiVal]++;
            list.add(asciiVal);
        }

        // sort the list
        list.sort((a, b) -> freqArr[a] == freqArr[b] ? a - b : freqArr[b] - freqArr[a]);

        char[] charrArr = new char[s.length()];
        int x = 0;
        for (int ascii : list) {
            charrArr[x] = (char) ascii;
            x++;
        }


        return new String(charrArr);
    }

    private static String sortCharacterByFrequencyViaPriorityQueue(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : map.keySet()) {
            priorityQueue.offer(c);
        }

        while (!priorityQueue.isEmpty()) {
            char c = priorityQueue.poll();
            for (int i = 0; i < map.get(c); i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
