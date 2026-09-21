class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            // If today's price is higher,
            // calculate the profit from selling today.
            if (buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                // A lower price gives us a better future buying opportunity.
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }
}