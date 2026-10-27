class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (nums[left] < nums[right]) { // window is sorted, min is at left
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid]) {  // left half sorted, pivot is to the right
                left = mid + 1;
            } else {
                right = mid;                // pivot is in (left, mid]
            }
        }
        return nums[left];
    }
}
