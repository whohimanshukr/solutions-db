class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // Track the current streak of consecutive 1s
        int count = 0;
        
        // Track the maximum streak of 1s found so far
        int max = 0;

        // Iterate through each element in the input array
        for(int i = 0 ; i < nums.length ; i++){
            // If the current element is 1, increment the current streak
            if(nums[i] == 1){
                count++;
                // Update the maximum streak if the current streak exceeds it
                max = Math.max(max, count);
            } else {
                // Reset the current streak counter when a 0 is encountered
                count = 0;
            }
        }

        // Return the highest number of consecutive 1s found
        return max;
    }
}