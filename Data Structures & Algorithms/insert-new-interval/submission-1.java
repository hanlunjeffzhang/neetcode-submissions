class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean mergeDone = false;
        for (int i = 0; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            if (mergeDone || currInterval[1] < newInterval[0]) {
                result.add(currInterval);
            } else if (currInterval[0] > newInterval[1]) {
                if (!mergeDone) {
                    result.add(newInterval);
                    mergeDone = true;
                }
                result.add(currInterval);
            } else {
                newInterval[0] = Math.min(currInterval[0], newInterval[0]);
                newInterval[1] = Math.max(currInterval[1], newInterval[1]);
            }
        }
        if (!mergeDone) {
            result.add(newInterval);
        }
        return result.toArray(new int[0][0]);
    }
}
