package questions;

public class CoinChange {


    /*
        You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
        Return the fewest number of coins that you need to make up that amount.
        If that amount of money cannot be made up by any combination of the coins, return -1.
        You may assume that you have an infinite number of each kind of coin.

        Example 1:

        Input: coins = [1,2,5], amount = 11
        Output: 3
        Explanation: 11 = 5 + 5 + 1
        Example 2:

        Input: coins = [2], amount = 3
        Output: -1
        Example 3:

        Input: coins = [1], amount = 0
        Output: 0

        Constraints:

        1 <= coins.length <= 12
        1 <= coins[i] <= 231 - 1
        0 <= amount <= 104
     */
    public static void main(String[] args) {

        int[] coins = new int[] {186,419,83,408};
        int amount = 6249;

        int noOfChange = coinChange(coins, amount);
        System.out.println("min coins: " + noOfChange);

    }

    private static int coinChange(int[] coins,
                                  int amount) {

        // edge cases
        if (coins.length > 0) {
            if (amount == 0) {
                return 0;
            }

            if (coins.length == 1 && amount < coins[0]) {
                return -1;
            }

            if (coins.length == 1 && amount > coins[0] && amount % coins[0] != 0) {
                return -1;
            }
        }

        int min = Integer.MAX_VALUE;
        int diff = 0;
        int minCoinsCount = 0;

        minCoinsCount = getMinCoinsCount(coins, amount, min, minCoinsCount);


        return minCoinsCount;
    }

    private static int getMinCoinsCount(int[] coins,
                                        int amount,
                                        int min,
                                        int minCoinsCount) {
        minCoinsCount++;
        int diff;
        int countNegatives = 0;
        for (int coin : coins) {
            diff = amount - coin;
            if (diff < 0) {
                countNegatives++;
            }
            if (diff > 0 && diff < min) {
                min = diff;
            } else if (diff == 0) {
                return minCoinsCount;
            } else if (countNegatives == coins.length) {
                return -1;
            }
        }
        return getMinCoinsCount(coins, min, Integer.MAX_VALUE, minCoinsCount);
    }

    private static void addDiff(int diff) {

    }
}
