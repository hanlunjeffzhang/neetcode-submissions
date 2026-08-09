class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = 3;
        for (int i = 0; i < edges.length; i++) {
            n = Math.max(n, Math.max(edges[i][0], edges[i][1]));
        }

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int root1 = findParent(parent, edge[0] - 1);
            int root2 = findParent(parent, edge[1] - 1);
            if (root1 == root2) {
                return edge;
            }
            parent[root2] = root1;
        }
        return null;
    }

    private int findParent(int[] parent, int node) {
        while (parent[node] != node) {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return parent[node];
    }
}
