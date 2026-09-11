/*
 * MEMORY CARD
 * 
 * Problem: LeetCode #509 — Fibonacci Number
 * Pattern: Space-Optimized Dynamic Programming (Bottom-Up)
 * 
 * Core idea:
 * Calculate from the bottom up (0 to n), maintaining a sliding window of 
 * only the last two calculated numbers to save memory.
 * 
 * Important variables:
 * - prev2      -> represents F(n-2)
 * - prev1      -> represents F(n-1)
 * - currentSum -> represents the newly calculated F(n)
 * 
 * Key decision:
 * - if n == 0 -> return 0
 * - if n == 1 -> return 1
 * 
 * Complexity:
 * - Time: O(n) — We iterate through the loop n - 1 times.
 * - Space: O(1) — We only use three variables, regardless of how large n is.
 * 
 * What I should remember:
 * Don't use recursion for basic Fibonacci unless forced to; a simple loop 
 * with two variables is faster and uses almost no memory.
 */
class Solution {
    public int fib(int n) {
        // 1. Handle our base cases immediately
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        
        // 2. Set up our starting window
        int prev2 = 0; 
        int prev1 = 1; 
        
        // 3. Slide the window forward until we reach n
        for (int i = 2; i <= n; i++) {
            int currentSum = prev1 + prev2;
            prev2 = prev1;
            prev1 = currentSum;
        }
        
        // 4. Return the last updated value
        return prev1;
    }
}