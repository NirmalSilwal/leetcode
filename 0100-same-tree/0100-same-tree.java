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
    // 1st approach
    // idea - find inorder traversal of both tree and compare that 
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        
        List<TreeNode> inorderP = new ArrayList<>();
        inorder(p, inorderP);
        
        List<TreeNode> inorderQ = new ArrayList<>();
        inorder(q, inorderQ);
        
        if (inorderP.size() != inorderQ.size()) return false;
        
        for (int i = 0; i < inorderP.size(); i++) {
            TreeNode first = inorderP.get(i);
            TreeNode second = inorderQ.get(i);

            if (first.val != second.val) 
                return false;
            
            if (first.left != null) {
                if (second.left == null) return false;
                if (first.left.val != second.left.val) return false;
            }
            
            if (first.right != null) {
                if (second.right == null) return false;
                if (first.right.val != second.right.val) return false;
            } 
        }
        
        return true;
    }

    // LNR, Left Node Right
    private void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
    
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
    
    // 2nd approach
    // recursive approach
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        
        if (p == null && q == null) return true;
        
        if (p == null && q != null || p != null && q == null || p.val != q.val) 
            return false;
        
        boolean leftAnswer = isSameTree(p.left, q.left);
        boolean rightAnswer = isSameTree(p.right, q.right);
    
        return leftAnswer && rightAnswer;
    }
    
    // 3rd approach - iterative
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q == null || p == null && q != null) return false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        
        while (!queue.isEmpty()) {
            TreeNode first = queue.poll();
            TreeNode second = queue.poll();
            
            if (first == null && second == null) continue;
            
            else if (first == null || second == null ||  first.val != second.val) return false;
            
            queue.add(first.left);
            queue.add(second.left);
            queue.add(first.right);
            queue.add(second.right);
        }
        
        return true;
    }

}