class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE; // or n + 1

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum = sum - nums[left];
                left++;
            }
        }

        // 3. What do we return at the end?
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
