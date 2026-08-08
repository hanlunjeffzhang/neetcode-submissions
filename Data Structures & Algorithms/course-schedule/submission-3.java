class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        List<Set<Integer>> graph = new ArrayList<Set<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new HashSet<Integer>());
        }

        for (int i = 0; i < prereq.length; i++) {
            int from = prereq[i][1];
            int to = prereq[i][0];
            graph.get(from).add(to);
        }
        
        boolean[] loop = new boolean[1];
        for (int i = 0; i < numCourses; i++) {
            int[] visited = new int[numCourses];
            dfs(graph, visited, i, loop);
            if (loop[0]) {
                return false;
            }
        }  
        return true;
    }

    private void dfs(List<Set<Integer>> graph, int[] visited, int index, boolean[] loop) {
        if (visited[index] == 2) {
            return;
        } else if (visited[index] == 1) {
            loop[0] = true;
            return;
        }

        visited[index] = 1;
        for (int next : graph.get(index)) {
            dfs(graph, visited, next, loop);
        }
        visited[index] = 2;
    }
}
