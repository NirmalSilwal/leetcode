**TLE solution, works for small test cases**
```
class Solution {
int count = 0;
public int uniquePaths(int m, int n) {
boolean[][] visited = new boolean[m][n];
mazePaths(0, 0, m, n, visited);
return count;
}
private void mazePaths(int currRow, int currCol, int m, int n, boolean[][] visited) {
if (currRow == m - 1 && currCol == n - 1) {
count++; // path found
return;
}
// boundary checks
if (currRow == -1 || currCol == -1 || currRow == m || currCol == n || visited[currRow][currCol]) {
return;
}
visited[currRow][currCol] = true; // mark current position as visited
// move down
mazePaths(currRow + 1, currCol, m, n, visited);
// move right
mazePaths(currRow, currCol + 1, m, n, visited);
// backtrack and mark as unvisited
visited[currRow][currCol] = false;
}
}
```