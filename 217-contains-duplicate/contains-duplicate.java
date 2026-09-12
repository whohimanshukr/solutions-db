class Solution {
    public boolean containsDuplicate(int[] nums) {

        // Sort the array so duplicates become adjacent
        Arrays.sort(nums);

        // Check neighboring elements
        for (int i = 1; i < nums.length; i++) {

            // If two adjacent values are equal, duplicate exists
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }

        // No duplicate found
        return false;
    }
}