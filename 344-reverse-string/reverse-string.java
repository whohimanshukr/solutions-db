/*
 * ============================================================================
 * MEMORY CARD
 * ============================================================================
 * Problem: LeetCode #344 — Reverse String
 * Pattern: Two Pointers (Opposite Direction / Inward-facing)
 * 
 * Core Idea:
 * Initialize two pointers at opposing ends of the array. Swap the values at
 * both pointers, then shift them inward until they cross in the middle.
 * 
 * Important Variables:
 * - left  -> pointer starting at index 0, moving right (left++)
 * - right -> pointer starting at index s.length - 1, moving left (right--)
 * - temp  -> temporary storage to hold s[left] during in-place swap
 * 
 * Key Decision:
 * - while (left < right) -> stops as soon as pointers meet or cross, cleanly
 *                           avoiding redundant swaps on the middle element.
 * 
 * Complexity:
 * - Time:  O(N) -> Exactly N/2 swaps, which scales linearly.
 * - Space: O(1) -> In-place modification using a single primitive variable.
 * 
 * What to Remember:
 * In-place linear reversal is best solved using two inward-facing pointers
 * swapping elements until they meet at the center.
 * ============================================================================
 */

class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        // Move inward from both edges toward the middle
        while (left < right) {
            // Three-step swap using temp variable
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;

            // Step pointers inward
            // left++;
            // right--;
        }
    }
}