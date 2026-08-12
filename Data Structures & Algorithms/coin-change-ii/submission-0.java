class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            int c = coins[i];
            for (int a = 1; a < amount + 1; a++) {
                if (a >= c) {
                    dp[a] += dp[a - c];
                }
            }
        }   
        return dp[amount];
    }
}
