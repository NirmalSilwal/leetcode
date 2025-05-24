/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int maxVal[] = new int[1]; // to track maximum value at each step, passing as ref
        maxVal[0] = Integer.MIN_VALUE;
        maxHelper(root, maxVal); 
        return maxVal[0];
    }

    public int maxHelper(TreeNode root, int[] maxi) {
        if (root == null) return 0; // leafs

        int leftMaxSum = Math.max(0, maxHelper(root.left, maxi)); // 0 for negative sum 
        int rightMaxSum = Math.max(0, maxHelper(root.right, maxi));

        maxi[0] = Math.max(maxi[0], leftMaxSum + rightMaxSum + root.val);

        return Math.max(leftMaxSum, rightMaxSum) + root.val; // for each node return self plus max of left and right
    }
}