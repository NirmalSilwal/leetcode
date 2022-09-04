/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    // approach 1 - bfs
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        
        Map<Node, Node> map = new HashMap<>(); // original node and it's clone mapping
        map.put(node, new Node(node.val, new ArrayList<Node>()));
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                Node removed = queue.poll();
                
                for (Node nbr : removed.neighbors) {
                    
                    if (!map.containsKey(nbr)) {
                        
                        queue.add(nbr);
                        map.put(nbr, new Node(nbr.val, new ArrayList<Node>()));
                    }
                    // now linking in cloned graph
                    Node clonedNewNode = map.get(removed);
                    clonedNewNode.neighbors.add(map.get(nbr));
                }
            }
        }
        
        return map.get(node);
    }
}