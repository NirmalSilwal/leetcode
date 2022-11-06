/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    // using BFS
    public int maxDepth1(Node root) {
        
        if (root == null) return 0;
        
        int depth = 0;
        Queue<Node> queue = new LinkedList();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                Node currNode = queue.poll();
                for (Node node : currNode.children) {
                    queue.offer(node);
                }
            }
            depth++;
        }
        return depth;
    }
    
    // using DFS
    private int depth;
    public int maxDepth(Node root) {
        if (root == null) return 0;
        helper(root, 1); // current node, level
        return depth;
    }
    
    private void helper(Node root, int level) {
        if (root == null) return;
        
        depth = Math.max(depth, level);
        
        for (Node child : root.children) {
            helper (child, level + 1);
        }
        
    }
}