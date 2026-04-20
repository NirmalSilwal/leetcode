/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }

    private Node build(int[][] grid, int row, int col, int size) {

        if (isUniform(grid, row, col, size)) {
            return new Node(grid[row][col] == 1, true);
        }

        int half = size / 2;

        Node topLeft = build(grid, row, col, half);
        Node topRight = build(grid, row, col + half, half);
        Node bottomLeft = build(grid, row + half, col, half);
        Node bottomRight = build(grid, row + half, col + half, half);

        // for non-leaf node value can be anything so passing true here
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    // checks if all value in that grid section is same
    private boolean isUniform(int[][] grid, int row, int col, int size) {
        int value = grid[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {

                if(grid[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}