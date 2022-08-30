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
    /*
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
  */
    
    // 2nd approach using inorder traversal since it gives output in ascending order
    /*
    public int kthSmallest(TreeNode root, int k) {
        
        List<Integer> inorderList = new ArrayList<>();
        
        inorder(root, inorderList);
        
        return inorderList.get(k - 1);
    }
         
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        
        // left, node, right
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    */
    
    // 3rd approach, optimizing 2nd approach
    private int count = 0;
    private int kth = -1;    
    
    public int kthSmallest(TreeNode root, int k) {               
        inorder(root, k); 
        return kth;
    }
 
    private void inorder(TreeNode root, int k) {
        
        if (root == null) return;
        
        inorder(root.left, k);
        
        count++;
        if (count == k) {
            kth = root.val;
            return;
        }
        
        inorder(root.right, k);
    }
}