class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 == 1) {
            return false;
        }
        int target = total / 2;
        boolean[] possibleSum = new boolean[target + 1];
        possibleSum[0] = true;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n > target) {
                return false;
            }
            for (int j = target; j >= n; j--) {
                if (possibleSum[j - n]) {
                    possibleSum[j] = true;
                }
            }
        }

        return possibleSum[target];
    }
}
