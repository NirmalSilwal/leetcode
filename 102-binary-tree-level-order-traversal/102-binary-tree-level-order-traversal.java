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
    // 1st approach: bfs, O(N) time, O(N) space
    /*
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> traversal = new ArrayList<>();
        if (root == null) { // edge case
            return traversal;
        }  
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
              
        while (!queue.isEmpty()) { // bfs
            
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
    */
    
    // 2nd approach - recursive
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        dfs(root, 1, traversal);
        return traversal;
    }
    
    private void dfs(TreeNode root, int level, List<List<Integer>> traversal) {
        
        if (root == null) return;
        
        if (traversal.size() < level) {
            traversal.add(new ArrayList<>());
        }
        traversal.get(level-1).add(root.val);
        
        dfs(root.left, level + 1, traversal);
        dfs(root.right, level + 1, traversal);
    }
}