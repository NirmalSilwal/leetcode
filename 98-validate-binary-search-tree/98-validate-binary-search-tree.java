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
    
    // 1st approach
    /*
    public boolean isValidBST(TreeNode root) {
       return validateBST(root, null, null);
    }
    
    // @param: low defines minimum value that root must hold
    // @param: high defines maximum value that root can hold
    private boolean validateBST(TreeNode root, Integer low, Integer high) {
        if (root == null)
            return true;
        
        if (low != null && root.val <= low || high != null && root.val >= high) 
            return false;
               
        boolean isLeftSubtreeValid = validateBST(root.left, low, root.val);
        boolean isRightSubtreeValid = validateBST(root.right, root.val, high);

        return isLeftSubtreeValid && isRightSubtreeValid;
    }
    */
    
    // 2nd approach
    Integer previous = null;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);   
    }
    
    private boolean inorder(TreeNode root) {
        if (root == null)
            return true;
        
        if (!inorder(root.left))
            return false;
        
        if (previous != null && root.val <= previous)
            return false;
        
        previous = root.val;
        
        return inorder(root.right);
    }
}