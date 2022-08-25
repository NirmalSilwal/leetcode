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
    /*
    // 1st approach - extra space with bfs, level order traversal
    // O(N) time, O(N) space
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
    */
    
    // follow up - O(1) space, O(N) time
    public Node connect(Node root) { 
        
        if (root == null) return root;
        
        Node head = root;
        
        while (head != null) {
            
            Node dummyNodeHead = new Node();
            Node temp = dummyNodeHead;
            
            // while traversing head in upper level, we process links in next level with temp pointer
            // for each level, traverse like linkedlist and form connection of next pointer
            while (head != null) {
                if (head.left != null) {
                    temp.next = head.left;
                    temp = temp.next;
                }
                if (head.right != null) {
                    temp.next = head.right;
                    temp = temp.next;
                }
                head = head.next;
            }
            
            // now we reach the end of current level indicated by head pointer to null
            // now we have to point head to first node in next level
            // since dummyNodeHead was at first position in each level, 
            // other links were processed by temp pointer in that level preserving dummy node initial position
            head = dummyNodeHead.next; 
            // in the last level, since both if condition inside 2nd while loop won't execute so 
            // temp will not move hence, dummyNodeHead will also be unchanged, so next pointer of it will be null
            // thus when we do head=dummyNodeHead.next, this will give null & hence terminates the 1st while loop
        }
        
        return root;
    }
}