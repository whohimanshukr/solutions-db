class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // Track the current streak of consecutive 1s
        int count = 0;
        
        // Track the maximum streak of 1s found so far
        int max = 0;

        // Iterate through each element in the input array using an enhanced for-loop
        for (int num : nums) {
            if (num == 1) {
                // Increment current streak counter for every 1 encountered
                count++;
            } else {
                // When a 0 breaks the streak, record the highest count seen so far
                max = Math.max(max, count);
                // Reset current streak counter for the next sequence
                count = 0;
            }
        }

        // Final check: update max to account for a streak ending at the very last element
        return Math.max(max, count);
    }
}