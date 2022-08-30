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
    // 1st approach using min heap
    public int kthSmallest(TreeNode root, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        dfs(root, minHeap);
        
        // now popping minHeap k times
        int kth = -1;
        for (int i = 1; i <= k; i++) {
            kth = minHeap.poll();
        }
        
        return kth;
    }
    
    private void dfs(TreeNode root, PriorityQueue<Integer> minHeap) {       
        
        if (root == null) return;        
        
        minHeap.add(root.val);
        
        dfs(root.left, minHeap);
        
        dfs(root.right, minHeap);
    }
}