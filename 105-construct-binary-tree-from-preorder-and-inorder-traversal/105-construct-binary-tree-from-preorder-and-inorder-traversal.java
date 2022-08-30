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
    
    Map<Integer, Integer> map = new HashMap<>(); // index mapping of inorder
    int preIndex = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {            
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i); // value, index   
        } 
        
        return buildRecursive(preorder, inorder, 0, inorder.length - 1);
    }
    
    // start: start index in inorder, end: end index in inorder
    private TreeNode buildRecursive(int[] preorder, int[] inorder, int start, int end) {
        if (start > end)
            return null;
        
        TreeNode root = new TreeNode(preorder[preIndex++]);
   
        // find index of root node
        int index = map.get(root.val);
        
        root.left = buildRecursive(preorder, inorder, start, index - 1);
        root.right = buildRecursive(preorder, inorder, index + 1, end);
        
        return root;
    }
}