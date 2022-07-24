- since the input in sorted in row and column, I am getting the intuition that somewhere we can use binary search here to solve it efficiently
- let's try brute force** O(mn)** solution also, solving each row and column element, here at worse it could go upto 9*10^4 runtime
- and the brute force solution is accepted
​
Now let's apply binary search and see  ...
​
```
// optimal solution - using binary search
/*
public boolean searchMatrix(int[][] matrix, int target) {
int start = 0, end = matrix.length - 1;
int row = 0, col = 0;
while (start <= end) {
int mid = start + (end - start) / 2;
if (matrix[row][mid] == target) {
return true;
} else if (target < matrix[row][mid]) {
col = mid - 1;
} else {
col = mid + 1;
}
if (matrix[mid][col] == target)
return true;
else if (target < matrix[mid][col])
row = mid -1;
else
row = mid + 1;
}
}
// .... to be continued
*/
```