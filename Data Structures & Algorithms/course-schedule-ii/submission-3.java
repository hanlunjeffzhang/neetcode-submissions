class Solution {
    public int[] findOrder(int numCourses, int[][] prereq) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < prereq.length; i++) {
            int from = prereq[i][1];
            int to = prereq[i][0];
            inDegree[to]++;
            graph.get(from).add(to);
        }

        Queue<Integer> q = new LinkedList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                result.add(i);
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int index = q.remove();
                List<Integer> next = graph.get(index);
                for (int nextIndex : next) {
                    inDegree[nextIndex]--;
                    if (inDegree[nextIndex] == 0) {
                        result.add(nextIndex);
                        q.add(nextIndex);
                    }
                }
            }
        }

        return (result.size() == numCourses) ? result.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }
}
