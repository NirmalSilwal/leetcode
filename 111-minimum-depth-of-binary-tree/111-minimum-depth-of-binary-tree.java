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
    public int minDepth(TreeNode root) {
        if (root == null) 
            return 0; 
        
        // doing BFS traversal for min depth
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        int depth = 1;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                
                TreeNode node = queue.poll();
            
                if (node.left == null && node.right == null) {
                    return depth;
                }

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
            
            depth++;
        }
        
        return -1;
    }
    
}