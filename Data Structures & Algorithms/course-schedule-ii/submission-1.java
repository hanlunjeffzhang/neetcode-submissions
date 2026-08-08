class Solution {
    public int[] findOrder(int numCourses, int[][] prereq) {
        int[] indegree = new int[numCourses];
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new HashSet<Integer>());
        }

        for (int i = 0; i < prereq.length; i++) {
            int from = prereq[i][1];
            int to = prereq[i][0];
            graph.get(from).add(to);
            indegree[to]++;
        }

        int[] visited = new int[numCourses];
        int[] indegreeCopy = Arrays.copyOf(indegree, indegree.length);
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
               if (isLoop(graph, i, visited)) {
                    return new int[0];
               }
               makeResult(graph, i, indegreeCopy, result);
            }
        }
        return (result.size() == numCourses) ? result.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }

    private boolean isLoop(List<Set<Integer>> graph, int index, int[] visited) {
        if (visited[index] == 2) {
            return false;
        } else if (visited[index] == 1) {
            return true;
        }
        visited[index] = 1;
        for (int next : graph.get(index)) {
            if (isLoop(graph, next, visited)) {
                visited[index] = 2;
                return true;
            }
        }
        visited[index] = 2;
        return false;
    }

    private void makeResult(List<Set<Integer>> graph, int index, int[] indegree, List<Integer> result) {
        indegree[index]--;
        if (indegree[index] > 0) {
            return;
        }
        result.add(index);
        for (int next : graph.get(index)) {
            makeResult(graph, next, indegree, result);
        }
    }

    
}
