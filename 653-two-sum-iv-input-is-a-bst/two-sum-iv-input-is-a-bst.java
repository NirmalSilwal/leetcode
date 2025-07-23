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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nodeList = new ArrayList<>();
        inorder(root, nodeList);

        int head = 0, tail = nodeList.size() - 1;

        while (head < tail) {
            int sum = nodeList.get(head) + nodeList.get(tail);
            if (sum == k) return true;
            if (sum < k) {
                head++;
            } else {
                tail--;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> nodeList) {
        if (root == null) return; // LNR: left node right

        inorder(root.left, nodeList);
        nodeList.add(root.val);
        inorder(root.right, nodeList);
    }
}