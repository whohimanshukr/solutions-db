class Solution {

    public void moveZeroes(int[] nums) {

        // j = position where the next non-zero value should be placed.
        // i = scans through every element of the array.
        int j = 0;

        // STEP 1:
        // Move all non-zero values toward the beginning of the array.
        for (int i = 0; i < nums.length; i++) {

            // If the current value is non-zero, we want to keep it.
            if (nums[i] != 0) {

                // Place the non-zero value at the next available position (j).
                // j can never be ahead of i because j only moves when we
                // find a non-zero value.
                nums[j] = nums[i];

                // Move j forward so it points to the next position
                // where another non-zero value can be placed.
                j++;
            }
        }

        // STEP 2:
        // At this point, all non-zero values are correctly placed
        // from index 0 up to j - 1.
        //
        // Everything from index j to the end should be zero.
        for (int k = j; k < nums.length; k++) {

            // Fill the remaining positions with zeroes.
            nums[k] = 0;
        }

        // Time Complexity: O(n)
        // We scan the array at most twice → O(n) + O(n) = O(n).
        //
        // Space Complexity: O(1)
        // We modify the original array and only use a few variables.
    }
}