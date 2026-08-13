class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] max = new int[3];
        for (int i = 0; i < triplets.length; i++) {
            int[] curr = triplets[i];
            if (curr[0] > target[0] || curr[1] > target[1] || curr[2] > target[2]) {
                continue;
            }
            max[0] = Math.max(curr[0], max[0]);
            max[1] = Math.max(curr[1], max[1]);
            max[2] = Math.max(curr[2], max[2]);
        }
        boolean matches = (max[0] == target[0]) && (max[1] == target[1]) && (max[2] == target[2]);
        return matches;
    }
}
