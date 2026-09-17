/*
 * ============================================================================
 * MEMORY CARD
 * ============================================================================
 * Problem: LeetCode #345 — Reverse Vowels of a String
 * Pattern: Two Pointers (Inward-Facing with Conditional Step)
 * 
 * Core Idea:
 * Convert the immutable String into a mutable char array. Use two pointers 
 * moving inward: advance past non-vowels, and swap only when both pointers 
 * are positioned on vowels.
 * 
 * Important Variables:
 * - arr   -> mutable char[] copy of the input string
 * - left  -> pointer starting at index 0, advancing rightwards (left++)
 * - right -> pointer starting at index arr.length - 1, advancing leftwards (right--)
 * - temp  -> temporary char storage for in-place swapping
 * 
 * Key Decisions:
 * - if (!isVowel(arr[left]))   -> left++ (skip consonant on the left)
 * - else if (!isVowel(arr[right])) -> right-- (skip consonant on the right)
 * - else                       -> swap vowels, then advance both (left++, right--)
 * 
 * Complexity:
 * - Time:  O(N) -> Single pass with two pointers + string-to-array conversions.
 * - Space: O(N) -> Auxiliary char array of length N required due to String immutability.
 * 
 * What to Remember:
 * When filtering/reversing specific elements with two pointers, hold a valid
 * target element stationary until its matching partner is found on the other side.
 * ============================================================================
 */

class Solution {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (!isVowel(arr[left])) {
                left++;
            } else if (!isVowel(arr[right])) {
                right--;
            } else {
                // Both are vowels: swap and advance both pointers
                char temp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = temp;
            }
        }

        return new String(arr);
    }

    private boolean isVowel(char c) {
        switch (c) {
            case 'a': case 'e': case 'i': case 'o': case 'u':
            case 'A': case 'E': case 'I': case 'O': case 'U':
                return true;
            default:
                return false;
        }
    }
}