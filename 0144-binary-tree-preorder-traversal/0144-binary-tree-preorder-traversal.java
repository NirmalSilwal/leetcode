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
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    
    // NLR (node, left right) visit
    private void helper(TreeNode root, List<Integer> list) {
        
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }
        
        list.add(root.val);

        helper(root.left, list);
        
        helper(root.right, list);
    }
    
    // iterative approach
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            
            TreeNode currNode = stack.pop();
            
            if (currNode != null) {
                list.add(currNode.val);
                stack.push(currNode.right);
                stack.push(currNode.left);
            } 
        }
        
        return list;
    }
}