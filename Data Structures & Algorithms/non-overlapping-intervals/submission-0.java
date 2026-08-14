class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int[] merging = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] >= merging[1]) {
                merging = curr;
            } else {
                count++;
            }
        }

        return count;
    }
}
