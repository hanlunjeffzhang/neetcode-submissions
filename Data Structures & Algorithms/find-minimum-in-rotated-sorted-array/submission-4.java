class Solution {
    public int findMin(int[] nums) {
        if (nums.length < 2 || nums[nums.length - 1] > nums[0]) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[nums.length - 1]) { // left sorted
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
