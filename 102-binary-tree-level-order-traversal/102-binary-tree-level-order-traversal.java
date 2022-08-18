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
    // 1st approach: bfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> traversal = new ArrayList<>();
        
        if (root == null) { // edge case
            return traversal;
        }  
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
              
        while (!queue.isEmpty()) { 
            
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                
                TreeNode removed = queue.remove();
                currentLevel.add(removed.val);

                if (removed.left != null) {
                    queue.add(removed.left);
                }
                if (removed.right != null) {
                    queue.add(removed.right);
                }   
            }
            traversal.add(new ArrayList<>(currentLevel));
        }
        return traversal;
    }
}