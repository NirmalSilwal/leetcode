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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> zigzag = new ArrayList();
        if (root == null) return zigzag;

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        boolean leftToRight = true; // indicates left to right traversal, if false then right to left

        while (!queue.isEmpty()) {
           
            int levelSize = queue.size();
            List<Integer> levelTraversal = new ArrayList();

            while (levelSize-- > 0) {
                
                TreeNode currentNode = queue.poll();
                
                if (leftToRight) levelTraversal.add(currentNode.val); // for left to right
                else levelTraversal.add(0, currentNode.val); // for right to left

                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            leftToRight = !leftToRight;
            zigzag.add(new ArrayList<Integer>(levelTraversal));
        }

        return zigzag;
    }
}