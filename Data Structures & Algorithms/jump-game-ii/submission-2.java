class Solution {
    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int reach = 0;
        int count = 0;
        int currentReach = 0;

        for (int i = 0; i < nums.length; i++) {
            reach = Math.max(reach, nums[i] + i);

            if (i >= currentReach && i < nums.length - 1) {
                count++;
                currentReach = reach;
            }
        }
        return count;
    }
}
