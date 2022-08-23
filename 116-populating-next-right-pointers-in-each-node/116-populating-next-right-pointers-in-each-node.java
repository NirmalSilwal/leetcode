/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        helper(root, null, true);
        return root;
    }
    
    // tracking each node parent and pointing current node next to its parent right child
    private void helper(Node node, Node parent, boolean isLeftChild) {

        if (node == null) return;
         
        // for root node parent will be null
        if (parent == null) 
            node.next = null;
        else {
            // pointing current node next to parent's right child
            if (isLeftChild)
                node.next = parent.right;         
            else
                node.next = parent.next == null ? null : parent.next.left; 
        }
             
        helper(node.left, node, true);
        helper(node.right, node, false);
    }
}