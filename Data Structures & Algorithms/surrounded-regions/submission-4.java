class Solution {
    private static final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public void solve(char[][] board) {
        Queue<int[]> q = new LinkedList<int[]>();
        for (int r = 0; r < board.length; r++) {
            char[] row = board[r];
            for (int c = 0; c < row.length; c++) {
                if ((r == 0 || c == 0 || r == board.length - 1 || c == row.length - 1) && board[r][c] == 'O') {
                    q.add(new int[]{r, c});
                    board[r][c] = 'Q';
                }
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] loc = q.remove();
                for (int dir = 0; dir < DIRECTIONS.length; dir++) {
                    int nr = loc[0] + DIRECTIONS[dir][0];
                    int nc = loc[1] + DIRECTIONS[dir][1];
                    if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] == 'O') {
                        board[nr][nc] = 'Q';
                        q.add(new int[]{nr, nc});
                    }
                }
            }
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'Q') {
                    board[r][c] = 'O';
                } else if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }

    }
}
