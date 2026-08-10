class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(maxLine(1, nums.length - 1, nums), maxLine(0, nums.length - 2, nums));
    }

    private int maxLine(int start, int end, int[] nums) {
        int[] maxAtHouse = new int[end - start + 2];
        maxAtHouse[0] = 0;
        maxAtHouse[1] = nums[start];

        for (int i = start + 1; i <= end; i++) {
            int dpIndex = i - start + 1;
            maxAtHouse[dpIndex] = Math.max(maxAtHouse[dpIndex - 1], maxAtHouse[dpIndex - 2] + nums[i]);
        }
        return maxAtHouse[maxAtHouse.length - 1];
    }
}
