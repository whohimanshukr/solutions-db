class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        
        // Left pointer defines the start boundary of our sliding window
        int left = 0;
        
        // Tracks the number of 0s present in the current window [left, right]
        int zeroCount = 0;
        
        // Stores the maximum length of a valid window seen so far
        int maxLength = 0;

        // Right pointer expands the window by traversing through each element
        for (int right = 0; right < n; right++) {
            
            // If the current element is 0, increment zeroCount to account for a flip
            if (nums[right] == 0) {
                zeroCount++;
            }

            // Shrink window: If 0s exceed the allowed budget 'k', slide 'left' rightward
            // until the window becomes valid again (zeroCount <= k)
            while (zeroCount > k) {
                // If the element leaving the window is a 0, decrement our zero counter
                if (nums[left] == 0) {
                    zeroCount--;
                }
                // Advance the left boundary to shrink the window size
                left++;
            }

            // Record the current valid window size (right - left + 1) if it's larger than maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }

        // Return the maximum consecutive 1s achievable with at most k flips
        return maxLength;
    }
}