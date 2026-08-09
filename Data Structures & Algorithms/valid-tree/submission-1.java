class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int root1 = findParent(parent, edge[0]);
            int root2 = findParent(parent, edge[1]);
            if (root1 == root2) {
                return false;
            }
            parent[root2] = root1;
        }
        return (n - 1) == edges.length;
    }

    private int findParent(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = findParent(parent, parent[node]);
        }
        return parent[node];
    }
}
