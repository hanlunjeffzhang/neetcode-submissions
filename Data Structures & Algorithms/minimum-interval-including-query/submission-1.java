class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        // Sort intervals by start point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Create query array with original indices
        Integer[] queryIndices = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) queryIndices[i] = i;
        Arrays.sort(queryIndices, (a, b) -> Integer.compare(queries[a], queries[b]));
        
        int[] result = new int[queries.length];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        int intervalIdx = 0;
        for (int queryIdx : queryIndices) {
            int query = queries[queryIdx];
            
            // Add all intervals that could contain this query
            while (intervalIdx < intervals.length && intervals[intervalIdx][0] <= query) {
                int len = intervals[intervalIdx][1] - intervals[intervalIdx][0] + 1;
                minHeap.offer(new int[]{len, intervals[intervalIdx][1]});
                intervalIdx++;
            }
            
            // Remove intervals where end < query
            while (!minHeap.isEmpty() && minHeap.peek()[1] < query) {
                minHeap.poll();
            }
            
            result[queryIdx] = minHeap.isEmpty() ? -1 : minHeap.peek()[0];
        }
        
        return result;
    }
}