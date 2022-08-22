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
   
    // one idea can be to first do level order traversals and then reverse odd index output
   /*
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> levelOrder = new ArrayList<>();
        // bfs level order traversal
        if (root == null) return levelOrder;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                
                TreeNode removedNode = queue.poll();           
                currentLevel.add(removedNode.val);
                
                if (removedNode.left != null) 
                    queue.add(removedNode.left);
                if (removedNode.right != null)
                    queue.add(removedNode.right);
            }
            levelOrder.add(new ArrayList<>(currentLevel));
        }

        // now as we get our level order traversals, for zigzag we simply reverse odd index output
        for (int i = 1; i < levelOrder.size(); i=i+2) {
            reverseArray(levelOrder.get(i));
        }
        
        return levelOrder;
    }
    
    private void reverseArray(List<Integer> arr) {
        int low = 0, high = arr.size() - 1;

        // two pointer approach
        while (low < high) {
            Integer temp = arr.get(low);
            arr.set(low, arr.get(high));
            arr.set(high, temp);
            low++;
            high--;
        }
    }
    */
    // approach 2 using DFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {        
        
        List<List<Integer>> levelOrder = new ArrayList<>();
        
        if (root == null) return levelOrder;
        
        dfs(root, 1, levelOrder);
        
        return levelOrder;
    }
      
    private void dfs(TreeNode root, int level, List<List<Integer>> levelOrder) {
        
        if (root == null) return;
        
        if (levelOrder.size() < level) {
            levelOrder.add(new ArrayList<>());
        }
        
        // since we start our level from 1 in our case, every even level has to be in reverse order
        if (level % 2 == 0) {
            levelOrder.get(level - 1).add(0, root.val); // for zigzag
        } else {
            levelOrder.get(level - 1).add(root.val);
        }
        
        if (root.left != null)
            dfs(root.left, level + 1, levelOrder);
        
        if (root.right != null)
            dfs(root.right, level + 1, levelOrder);
    }
}