class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        int[] inDeg = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph.get(from).add(to);
            inDeg[to]++;
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.remove();
                Set<Integer> nextNodes = graph.get(curr);
                for (int next : nextNodes) {
                    inDeg[next]--;
                    if (inDeg[next] == 0) {
                        q.add(next);
                    }
                }
            }
        }
        
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] > 0) {
                return false;
            }
        }

        return true;
    }
}