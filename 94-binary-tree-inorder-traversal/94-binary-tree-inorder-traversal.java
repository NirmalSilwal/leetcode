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
    // 1st approach: recursive solution
    /*
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> traversals = new ArrayList<>();
        
        inorder(root, traversals);
        
        return traversals;
    }
    
    private void inorder(TreeNode root, List<Integer> traversals) {
        
        if (root == null) return;
        
        if (root.left == null && root.right == null) {
            traversals.add(root.val);
            return;
        }
        
        // inorder: LNR (left, node, right)
        inorder(root.left, traversals);
        
        traversals.add(root.val);
        
        inorder(root.right, traversals);
    }
    */
    
    // 2nd approach: iterative solution
    /*
    public List<Integer> inorderTraversal(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> traversals = new ArrayList<>();
        TreeNode currentNode = root;
        
        while (currentNode != null || !stack.isEmpty()) {
            
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            
            currentNode = stack.pop();
            traversals.add(currentNode.val);
            currentNode = currentNode.right;            
        }
        
        return traversals;
    }
    */
    
    // 3rd approach - Morris Traversal
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> traversals = new ArrayList<>();
        TreeNode curr = root;
        
        while (curr != null) {
            // case 1: if right-skewed tree initially
            if (curr.left == null) {
                traversals.add(curr.val);
                curr = curr.right;
            } else {
                // if there exists left subtree
                // go to left subtree and find node which will be visited last in inorder 
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                
                if (prev.right == null) {
                    // create a thread
                    prev.right = curr;
                    curr = curr.left; // do the traversal
                } else {
                    // remove the thread and visit right
                    prev.right = null;
                    traversals.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        
        return traversals;
    }

}