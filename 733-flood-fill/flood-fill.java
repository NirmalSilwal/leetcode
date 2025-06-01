class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int sourceColor = image[sr][sc];
        if (color == sourceColor) return image;
        fill (image, sr, sc, sourceColor, color);
        return image;
    }

    private static void fill (int[][] image, int row, int col, int sourceColor, int color) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[row].length )
            return;
        if (image[row][col] != sourceColor)
            return;
        // fill with new color
        image[row][col] = color;

        fill (image, row, col - 1, sourceColor, color); // left
        fill (image, row, col + 1, sourceColor, color); // right
        fill (image, row - 1, col, sourceColor, color); // up
        fill (image, row + 1, col, sourceColor, color); // down
    }
}