class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] table = new int[cost.length + 1];
        table[0] = 0;
        table[1] = 0;

        for (int i = 2; i <= cost.length; i++) {
            table[i] = Math.min(table[i-2] + cost[i-2], table[i-1] + cost[i-1]);
        }
        return table[cost.length];
    }
}
