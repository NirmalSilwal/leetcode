/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    // 1st approach - recursive solution
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null || root == p || root == q) 
            return root;
     
        TreeNode leftSearch = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSearch = lowestCommonAncestor(root.right, p, q);
        
        if (leftSearch == null)
            return rightSearch;
        if (rightSearch == null)
            return leftSearch;
        else
            return root;
    }
    */
    
    // 2nd approach - iterative solution
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null) return root;
        
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>(); // child, parent mapping
        
        queue.add(root);
        parentMap.put(root, null);
        
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            
            TreeNode curr = queue.poll();
            
            if (curr != null) {
                parentMap.put(curr.left, curr);
                parentMap.put(curr.right, curr);
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        
        Set<TreeNode> set = new HashSet<>();
        
        while (p != null) {
            set.add(p);
            p = parentMap.get(p);
        }
        
        while (!set.contains(q)) {
            q = parentMap.get(q);
        }
        
        return q;
    }    
}