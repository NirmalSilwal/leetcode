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
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        
        ArrayList<TreeNode> preorder = new ArrayList<>();
        
        preOrderTraverse(root, preorder);

        TreeNode temp = root;
        
        int idx = 1; // position in preorder array

        while (idx != preorder.size()) {
            temp.left = null;
            temp.right = preorder.get(idx++);
            temp = temp.right;
        }
    }
    
    // Node Left Right
    private void preOrderTraverse(TreeNode root, ArrayList<TreeNode> preorder){
        if (root == null)
            return;
        
        preorder.add(root);
        preOrderTraverse(root.left, preorder);
        preOrderTraverse(root.right, preorder);
    }
}