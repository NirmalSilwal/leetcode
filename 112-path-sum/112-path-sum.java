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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum, 0);
    }
    
    private boolean helper(TreeNode root, int target, int currsum) {
        if (root == null) return false;
        
        // leaf node
        if (root.left == null && root.right == null) {
        // adding current leaf node value also since in recursive call it has sum upto its parent node
            currsum += root.val; 
            if (currsum == target)
                return true;
        }
        
        boolean leftscan = helper(root.left, target, currsum + root.val);
        boolean rightscan = helper(root.right, target, currsum + root.val);
        
        return leftscan || rightscan;
    }
}