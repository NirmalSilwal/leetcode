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
    public int sumOfLeftLeaves(TreeNode root) {
        
        if (root == null) return 0;
        
        if (root.left == null && root.right == null) return 0; 
        
        return findSumOfLeaves(root, false);
    }
    
    private int findSumOfLeaves(TreeNode root, boolean isLeftNode) {
        
        if (root == null) return 0;
        
        if (root.left == null && root.right == null) { // leaf node
            if (isLeftNode)
                return root.val; 
            else
                return 0;
        }
        
        int sum1 = findSumOfLeaves(root.left, true);
        int sum2 = findSumOfLeaves(root.right, false);
        
        return sum1 + sum2;
    }
}