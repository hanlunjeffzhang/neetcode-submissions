class Solution {
    public int uniquePaths(int m, int n) {
        return combination((m - 1) + (n - 1), (n - 1));
    }

    private int combination(int n, int r) {
        r = Math.min(r, n - r);

        long result = 1L;
        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }

        return (int)result;
    }
}
