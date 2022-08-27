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
    // 1st approach with extra space
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathp = new ArrayList<>();
        List<TreeNode> pathq = new ArrayList<>();
        
        searchPath(root, p, pathp);
        searchPath(root, q, pathq);
        
        int cursorP = 0, cursorQ = 0;
        boolean found = false;
        TreeNode result = null;
        
        while (cursorP < pathp.size() && cursorQ < pathq.size()) {
            // all node value are unique
            if (pathp.get(cursorP).val != pathq.get(cursorQ).val) {
                result = pathp.get(cursorP - 1);
                break ;
            }
            cursorP++;
            cursorQ++;
        }
        
        if (!found) {
            if (cursorP == pathp.size())  // if pathp is fully traversed
                result =  pathp.get(cursorP - 1);           
            
            else if (cursorQ == pathq.size())
                result = pathq.get(cursorQ - 1);
        }
     
        return result;
    }
    
    // dfs
    private void searchPath(TreeNode root, TreeNode node, List<TreeNode> path) {
        
        if (root.val == node.val) {
            path.add(root);
            return;
        }
        
        if (node.val < root.val) {
            path.add(root);
            searchPath(root.left, node, path);
        }
        
        if (node.val > root.val){
            path.add(root);
            searchPath(root.right, node, path);
        }
    }
    */

    /*
    // 2nd approach, recursive solution, 
    // O(N) time, O(N) space
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if (root == null) return null;
        
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        
        else if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else 
            return root;
    }
    */
    
    // 3rd approach, iterative solution
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode currentNode = root;
        
        while (currentNode != null) {
            
            int parentValue = currentNode.val;
            
            if (p.val > parentValue && q.val > parentValue)
                currentNode = currentNode.right;
            
            else if (p.val < parentValue && q.val < parentValue)
                currentNode = currentNode.left;
            else 
                return currentNode;
        }
        return null;
    }    
}