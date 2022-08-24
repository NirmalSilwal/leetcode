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
    // extra space with bfs, level order traversal
    public Node connect(Node root) {
        
        if (root == null) return root;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                
                Node removed = queue.poll();

                // in queue there will be node from at most two levels at at time
                if (i < levelSize - 1) {
                    removed.next = queue.peek();    
                }
                
                if (removed.left != null)
                    queue.add(removed.left);
                if (removed.right != null)
                    queue.add(removed.right);   
            }
        }
        
        return root;
    }
}