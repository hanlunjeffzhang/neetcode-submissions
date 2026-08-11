class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int[] maxEnding = new int[nums.length];
        int[] minEnding = new int[nums.length];

        maxEnding[0] = nums[0];
        minEnding[0] = nums[0];

        int max = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int prevMax = maxEnding[i - 1];
            int prevMin = minEnding[i - 1];

            maxEnding[i] = Math.max(curr, Math.max(curr * prevMax, curr * prevMin));
            minEnding[i] = Math.min(curr, Math.min(curr * prevMax, curr * prevMin));

            max = Math.max(maxEnding[i], max);
        }
        return max;
    }
}
