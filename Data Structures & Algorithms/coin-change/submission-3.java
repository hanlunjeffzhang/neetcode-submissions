class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        } else if (amount < Arrays.stream(coins).min().getAsInt()) {
            return -1;
        } 
        int[] countAtNum = new int[amount + 1];
        Arrays.fill(countAtNum, -1);
        for (int i = 0; i < coins.length; i++) {
            int c = coins[i];
            if (c <= amount) {
                countAtNum[c] = 1;
            }
        }

        for (int i = 1; i <= amount; i++) {
            int minCount = countAtNum[i];
            for (int j = 0; j < coins.length; j++) {
                int c = coins[j];
                if (i - c <= 0 || countAtNum[i - c] == -1) {
                    continue;
                }
                minCount = (minCount == -1) ? countAtNum[i - c] + 1 : Math.min(countAtNum[i - c] + 1, minCount);
            }
            countAtNum[i] = minCount;
        }
        return countAtNum[amount];
    }
}
