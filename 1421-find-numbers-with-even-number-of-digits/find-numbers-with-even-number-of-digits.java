class Solution {
    public int findNumbers(int[] nums) {
        // Tracks the total count of numbers with an even number of digits.
        // Declared outside the loop so its state persists across the entire array traversal.
        int count = 0;

        // Traverse each element in the array one by one: O(N) time
        for (int i = 0; i < nums.length; i++) {

            // Reset digit counter for each individual number
            int digits = 0;

            // Make a working copy of nums[i].
            // This prevents mutating the original array and keeps logic isolated.
            int num = nums[i];

            // Repeatedly strip off the last digit until no digits remain: O(log10(num)) time
            while (num > 0) {
                num /= 10;   // Integer division by 10 discards the least significant digit
                digits++;    // Count that a digit was removed
            }

            // Check if the total digit count is even using modulo arithmetic
            if (digits % 2 == 0) {
                count++;     // Valid number found; increment global counter
            }
        }

        // Return the final accumulated count
        return count;
    }
}
/*
 * 
 * MEMORY CARD
 * 
 * Problem: LeetCode #1295 — Find Numbers with Even Number of Digits
 *
 * Pattern: Array Traversal + Digit Extraction (Logarithmic reduction via division)
 *
 * Core Idea:
 * Scan the array, strip each number digit-by-digit using integer division (/ 10),
 * count the operations, and increment the answer whenever the count is even.
 *
 * Important Variables:
 * - count  -> running total of valid numbers found across the entire array
 * - num    -> independent working copy of nums[i] that shrinks to 0
 * - digits -> local counter tracking the number of digits in num
 *
 * Key Decisions:
 * - while (num > 0)      -> processes digits until the quotient hits zero
 * - num /= 10            -> drops the least significant digit in O(1)
 * - if (digits % 2 == 0) -> checks even parity before moving to the next element
 *
 * Complexity:
 * - Time Complexity:  O(N) (at most 6 divisions per number; N * 6 operations = O(N))
 * - Space Complexity: O(1) (only primitive integer variables allocated)
 *
 * What to Remember:
 * Repeated integer division by 10 (num /= 10) extracts digit count in logarithmic
 * time without string conversion overhead or heap allocations. Always isolate
 * values into local copies to avoid mutating input data.
 * 
 */