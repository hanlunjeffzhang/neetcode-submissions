class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<int[]>());
        }

        for (int i = 0; i < times.length; i++) {
            int from = times[i][0] - 1;
            int to = times[i][1] - 1;
            int time = times[i][2];
            graph.get(from).add(new int[]{to, time});
        }

        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[k - 1] = 0;

        Queue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[1] - b[1]));
        pq.add(new int[]{k - 1, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.remove();
            if (current[1] > minTime[current[0]]) {
                continue;
            }

            List<int[]> nextNodes = graph.get(current[0]);
            for (int[] next : nextNodes) {
                if (current[1] + next[1] < minTime[next[0]]) {
                    minTime[next[0]] = current[1] + next[1];
                    pq.add(new int[]{next[0], current[1] + next[1]});
                }
            }
        }

        int max = 0;
        for (int i = 0; i < minTime.length; i++) {
            if (minTime[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, minTime[i]);
        }
        return max;
    }
}
