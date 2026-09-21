/*
 * ============================================================================
 * MEMORY CARD
 * ============================================================================
 * Problem: LeetCode #121 — Best Time to Buy and Sell Stock
 * Pattern: One-Pass Greedy / Running Minimum Tracking
 * 
 * Core Idea:
 * As we scan left-to-right, keep track of the lowest price seen so far.
 * At every day, decide whether today gives a cheaper buying baseline or
 * a higher profit if sold today.
 * 
 * Important Variables:
 * - buyPrice  -> lowest price encountered so far (buying day)
 * - maxProfit -> greatest profit achieved from any valid buy/sell pair
 * - profit    -> potential profit if we sold at today's price (prices[i] - buyPrice)
 * 
 * Key Decisions:
 * - if (buyPrice < prices[i]) -> prices[i] can yield profit; check Math.max(maxProfit, profit)
 * - else                      -> prices[i] <= buyPrice; update buyPrice = prices[i]
 * 
 * Complexity:
 * - Time:  O(N) -> Single linear scan across the prices array.
 * - Space: O(1) -> Only a few primitive integer variables; no extra heap memory.
 * 
 * What I should remember:
 * For single-transaction buy/sell problems, you don't need future knowledge:
 * just remember the cheapest price from the past and evaluate profit on the fly.
 * ============================================================================
 */

class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            // If today's price is higher than our lowest buy price,
            // calculate the potential profit from selling today.
            if (buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                // A lower price gives us a better future buying baseline.
                buyPrice = prices[i];
            }
        }

        return maxProfit;
    }
}