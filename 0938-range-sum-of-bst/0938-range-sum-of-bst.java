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
    public int rangeSumBST1(TreeNode root, int low, int high) {

        List<Integer> traversal = new ArrayList();
        
        inorder(root, traversal);
        
        int sum = 0;
        for (int val : traversal) {
            if (val >= low && val <= high) sum += val;
        }
        
        return sum;
    }
    
    // LNR
    private void inorder(TreeNode root, List<Integer> traversal) {
        if (root == null) return;
        // leaf node
        if (root.left == null && root.right == null) {
            traversal.add(root.val);
            return;
        }
        
        inorder(root.left, traversal);
        traversal.add(root.val);
        inorder(root.right, traversal);
    }
    
    // 2nd approach
    public int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null) return 0;
        int sum = 0;
        
        if (root.val >= low && root.val <= high) 
            sum += root.val;
        
        if (root.val > low) 
            sum += rangeSumBST(root.left, low, high);
        
        if (root.val < high) 
            sum += rangeSumBST(root.right, low, high);
        
        return sum;
    }
    
}