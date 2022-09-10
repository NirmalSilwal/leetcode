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
    // approach 1 idea - using bfs, in queue last element in each level will be right view
    /*
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> view = new ArrayList<>();       
        if (root == null) return view;       
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int qsize = queue.size(); // each level size
            
            for (int i = 0; i < qsize; i++) {
                
                TreeNode removed = queue.poll();
                
                if (i == qsize - 1)
                    view.add(removed.val);
               
                if (removed.left != null) {
                     queue.offer(removed.left);
                }                    
                if (removed.right != null) {
                    queue.offer(removed.right);
                }
            }
        }   
        return view;
    }
    */
    // approach 2 - recursive
    public List<Integer> rightSideView(TreeNode root) {       
        
        List<Integer> view = new ArrayList<>();       
        
        if (root == null) return view; 
                
        rightView(root, view, 0);
        // leftView(root, view);
        
        return view;
    }
    
    private void rightView(TreeNode root, List<Integer> view, int currentLevel) {
        if (root == null)
            return;
        
        if (currentLevel == view.size()) {
            view.add(root.val);
        }
        
        rightView(root.right, view, currentLevel + 1);
        
        rightView(root.left, view, currentLevel + 1);
    }
    
    // left view of binary tree
    // idea: 1st node in each level in bfs / level order traversal would give left view
    private void leftView(TreeNode root, List<Integer> view) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // add in queue
        
        while (!queue.isEmpty()) {
            
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {

                TreeNode removed = queue.poll();

                if (i == 0)
                    view.add(removed.val);
                
                if (removed.left != null) 
                    queue.add(removed.left);
                
                if (removed.right != null)
                    queue.add(removed.right);
            }
        }
    }
}