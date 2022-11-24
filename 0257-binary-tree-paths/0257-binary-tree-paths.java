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
    public List<String> binaryTreePaths(TreeNode root) {
        
        List<String> paths = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        helper (root, paths, sb);
        
        return paths;
    }
    
    private void helper(TreeNode root, List<String> paths, StringBuilder sb) {

        if (root == null) return;

        int lengthBeforeRecursion = sb.length();
        sb.append(root.val);

        if (root.left == null && root.right == null) {
            paths.add(sb.toString());
        } 
        else {
            sb.append("->");
            helper(root.left, paths, sb);
            helper(root.right, paths, sb);
        }
        
        sb.setLength(lengthBeforeRecursion); // to explore other paths
    }
}