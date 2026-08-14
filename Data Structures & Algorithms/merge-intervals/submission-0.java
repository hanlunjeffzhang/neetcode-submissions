class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] merging = intervals[0];
        List<int[]> result = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (merging[1] < curr[0]) {
                result.add(merging);
                merging = curr;
            } else {
                merging[0] = Math.min(merging[0], curr[0]);
                merging[1] = Math.max(merging[1], curr[1]);
            }
        }
        result.add(merging);
        return result.toArray(new int[0][0]);
    }
}
