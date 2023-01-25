class Solution {
    public int snakesAndLadders(int[][] board) {
        int moves = 0, n = board.length;
        
        boolean[][] visited = new boolean[n][n];
        Queue<Integer> queue = new LinkedList();
        queue.add(1);
        visited[n - 1][0] = true; // start index bottom left of the board

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            while (levelSize-- > 0) {
                int currentRoll = queue.poll();
                if (currentRoll == n * n) return moves;

                for (int dice = 1; dice <= 6; dice++) {
                    if (currentRoll + dice > n * n) continue;
                    int[] boardPosition = findBoardPosition(currentRoll + dice, n);
                    int row = boardPosition[0], col = boardPosition[1];
                    if (visited[row][col]) continue;

                    visited[row][col] = true;
                    if (board[row][col] == -1) {
                        queue.add(dice + currentRoll);
                    } else {
                        queue.add(board[row][col]);
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    private int[] findBoardPosition(int dice, int n) {
        int[] position = new int[2];
        int row = n - (dice - 1)/ n - 1;
        int col = (dice - 1) % n;

        if (row % 2 == n % 2) {
            position[0] = row;
            position[1] = n - 1 - col;
        } else {
            position[0] = row;
            position[1] = col;
        }
        return position;
    }
}