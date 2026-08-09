class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int root1 = findParent(parent, edge[0]);
            int root2 = findParent(parent, edge[1]);
            parent[root2] = root1;
        }

        Set<Integer> groups = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            parent[i] = findParent(parent, i);
            groups.add(parent[i]);
        }

        return groups.size();
    }

    private int findParent(int[] parent, int node) {
        if (node != parent[node]) {
            parent[node] = findParent(parent, parent[node]);
        }
        return parent[node];
    }
}
