class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
        List<Map<Integer, Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new HashMap<Integer, Integer>());
        }

        for (int i = 0; i < times.length; i++) {
            int from = times[i][0] - 1;
            int to = times[i][1] - 1;
            int time = times[i][2];
            graph.get(from).put(to, time);
        }

        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);

        traverse(graph, k - 1, 0, minTime);

        int max = 0;
        for (int i = 0; i < minTime.length; i++) {
            if (minTime[i] == Integer.MAX_VALUE) {
                return -1;
            }
            max = Math.max(max, minTime[i]);
        }
        return max;
    }

    private void traverse(List<Map<Integer, Integer>> graph, int index, int currTime, int[] minTime) {
        if (currTime >= minTime[index]) {
            return;
        }

        minTime[index] = Math.min(minTime[index], currTime);
        System.out.println(index + ": " + minTime[index]);
        Map<Integer, Integer> nextNodes = graph.get(index);
        for (int next : nextNodes.keySet()) {
            int val = nextNodes.get(next);
            traverse(graph, next, minTime[index] + val, minTime);
        }
    }
}
