class Solution {
    public boolean canFinish(int numCourses, int[][] prereq) {
        int[] inDegree = new int[numCourses];
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new HashSet<Integer>());
        }

        for (int i = 0; i < prereq.length; i++) {
            int from = prereq[i][1];
            int to = prereq[i][0];
            inDegree[to]++;
            graph.get(from).add(to);
        }

        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.remove();
                Set<Integer> next = graph.get(curr);
                for (int index : next) {
                    inDegree[index]--;
                    if (inDegree[index] == 0) {
                        q.add(index);
                    }
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
