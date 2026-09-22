/*
 * ============================================================================
 * MEMORY CARD
 * ============================================================================
 * Problem: LeetCode #268 — Missing Number
 * Pattern: Bit Manipulation (XOR Cancellation)
 * 
 * Core Idea:
 * Any number XORed with itself cancels out to 0 (a ^ a = 0), and any number
 * XORed with 0 stays itself (a ^ 0 = a). XORing all expected numbers [0, n]
 * with all actual array numbers leaves only the missing number standing.
 * 
 * Important Variables:
 * - xor -> accumulator initialized to n (to account for the upper bound)
 * - i   -> loop index serving as the expected range values [0, n - 1]
 * 
 * Key Decision:
 * - xor ^= i ^ nums[i] -> cancels matching index and element pairs on the fly
 * 
 * Complexity:
 * - Time:  O(n) -> single pass over the array
 * - Space: O(1) -> constant auxiliary space; zero risk of integer overflow
 * 
 * What I should remember:
 * When duplicate pairs need to cancel out or a single odd-one-out needs to be 
 * isolated without risk of arithmetic overflow, reach for the XOR operator (^).
 * ============================================================================
 */

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = n; // Start with n since the loop runs 0 to n - 1
        
        for (int i = 0; i < n; i++) {
            xor ^= i ^ nums[i]; // XOR expected number 'i' and actual element 'nums[i]'
        }
        
        return xor;
    }
}