class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> index = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while(!index.isEmpty() && heights[index.peek()] > heights[i]) {
                int prevIndex = index.pop();
                int rectLeftBar = !index.isEmpty() ? index.peek() : -1;
                int currRect = (i - 1 - rectLeftBar) * heights[prevIndex];
                max = Math.max(max, currRect);
            }
            index.push(i);
        }
        
        while (!index.isEmpty()) {
            int prevIndex = index.pop();
            int rectLeftBar = !index.isEmpty() ? index.peek() : -1;
            int currRect = (heights.length - 1 - rectLeftBar) * heights[prevIndex];
            max = Math.max(max, currRect);
        }
        return max;
    }
}
