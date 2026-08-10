class Solution {
    public int rob(int[] nums) {
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] maxAtHouse = new int[nums.length + 1];
        maxAtHouse[0] = 0;
        maxAtHouse[1] = nums[0];
        maxAtHouse[2] = nums[1];
        for (int i = 3; i <= nums.length; i++) {
            maxAtHouse[i] = Math.max(maxAtHouse[i - 2], maxAtHouse[i - 3]) + nums[i - 1];
        }

        return Math.max(maxAtHouse[nums.length], maxAtHouse[nums.length - 1]);
    }
}
