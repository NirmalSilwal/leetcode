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
        int[] pathsum = new int[1];
        pathsum[0] = Integer.MIN_VALUE; // for case like [-3] as input
        helper(root, pathsum);
        return pathsum[0];
    }
    
    private int helper(TreeNode root, int[] pathsum) {
        
        if (root == null) return 0;
        
        int leftSum = Math.max(0, helper(root.left, pathsum));
        int rightSum = Math.max(0, helper(root.right, pathsum)); // 0 for negative path weights
        
        pathsum[0] = Math.max(pathsum[0], leftSum + rightSum + root.val);
        
        return root.val + Math.max(leftSum, rightSum);
    }
}