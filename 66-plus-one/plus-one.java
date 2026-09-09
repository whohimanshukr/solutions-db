class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
// Problem

// LeetCode #66 — Plus One

// Pattern

// Array + Carry

// Core idea

// Start from the rightmost digit because that's where addition begins.

// If digit < 9 → increment it and we're done.
// If digit 9 → turn it into 0 and carry 1 to the left.
// If every digit was 9 → create a new array with a leading 1.
// Important variables
// digits → the number represented as an array
// i      → current digit, moving from right → left
// result → new array needed only when every digit is 9
// Key decision
// if digits[i] < 9 → increment digit → return digits
// if digits[i] == 9 → make it 0 → continue left
// if loop finishes → every digit was 9 → return [1,0,0,...]
// Complexity
// Time:  O(n)
// Space: O(n)
// What you should remember

// Think of the +1 as a carry traveling from right to left. 9 passes the carry; anything below 9 absorbs it.

// And honestly, the most valuable thing you learned here wasn't the code.

// You learned to recognize why the loop goes backwards, why 9 becomes 0, why we return early, and why the extra array only exists after the loop.

// That's exactly the kind of understanding you're after.

// Tiny test before we close this problem

// No code this time.

// What should these produce?

// [4, 3, 2] → ?
// [4, 3, 9] → ?
// [9, 9]    → ?

// Try to solve them mentally using the carry traveling right → left model.