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
    // 1st approach: recursive solution
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> traversals = new ArrayList<>();
        
        inorder(root, traversals);
        
        return traversals;
    }
    
    private void inorder(TreeNode root, List<Integer> traversals) {
        
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            traversals.add(root.val);
            return;
        }
        
        // inorder: LNR (left, node, right)
        inorder(root.left, traversals);
        
        traversals.add(root.val);
        
        inorder(root.right, traversals);
    }
}