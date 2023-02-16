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
    public int maxDepth1(TreeNode root) {
        
        if (root == null) return 0;
        
        if (root.left == null && root.right == null) return 1;
        
        int leftDepth = 1 + maxDepth(root.left);
        int rightDepth = 1 + maxDepth(root.right);
        
        return Math.max(leftDepth, rightDepth);
    }
    
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 1;
        
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack();
        nodeStack.push(root);
        depthStack.push(1);
        
        while (!nodeStack.isEmpty()) {
            
            TreeNode currentNode = nodeStack.pop();
            int currentDepth = depthStack.pop();
            
            if (currentNode.left == null && currentNode.right == null) {
                depth = Math.max(depth, currentDepth);
            }
            
            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
                depthStack.push(currentDepth + 1);
            }
            
            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
                depthStack.push(currentDepth + 1);
            }
            
        }
        
        return depth;
    }
    
}