class Solution {
    public int trap(int[] height) {
        int i = 0;
        int j = height.length - 1;

        int leftMax = height[0];
        int rightMax = height[height.length - 1];

        int vol = 0;

        while (i < j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);

            if (leftMax < rightMax) {
                vol += leftMax - height[i];
                i++;
            } else {
                vol += rightMax - height[j];
                j--;
            }
        }
        return vol;
    }
}
