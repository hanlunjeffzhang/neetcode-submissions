class Solution {
    public int maxProfit(int[] prices) {
        int held = -prices[0];
        int sold = 0;
        int rest = 0;

        for (int i = 1; i < prices.length; i++) {
            int prevHeld = held;
            int prevSold = sold;
            int prevRest = rest;

            held = Math.max(prevHeld, prevRest - prices[i]);
            sold = prevHeld + prices[i];
            rest = Math.max(prevSold, prevRest);
        }
        return Math.max(sold, rest);
    }
}
