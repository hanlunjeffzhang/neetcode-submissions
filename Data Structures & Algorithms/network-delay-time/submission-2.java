class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<int[]>());
        }

        for (int i = 0; i < times.length; i++) {
            int from = times[i][0] - 1;
            int to = times[i][1] - 1;
            int t = times[i][2];
            graph.get(from).add(new int[]{to, t});
        }

        int[] minTime = new int[n];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[k - 1] = 0;
        pq.add(new int[]{k - 1, 0});

        while (!pq.isEmpty()) {
            int[] node = pq.remove();
            if (node[1] > minTime[node[0]]) {
                continue;
            }

            List<int[]> next = graph.get(node[0]);
            for (int i = 0; i < next.size(); i++) {
                int[] nextNode = next.get(i);
                if (node[1] + nextNode[1] < minTime[nextNode[0]]) {
                    minTime[nextNode[0]] = nextNode[1] + node[1];
                    pq.add(new int[]{nextNode[0], minTime[nextNode[0]]});
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
