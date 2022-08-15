/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // approach 1 using extra space O(N)
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        
        Node temp = head;
        Map<Node, Node> map = new HashMap<>(); // node, copy of node without any next/random pointers
        
        // make deep copy node only without next and random pointer
        while (temp != null) {
            Node copyCurrentNode = new Node(temp.val);
            map.put(temp, copyCurrentNode); 
            temp = temp.next;
        }
        
        // now making connection of next and random pointer
        temp = head;
        while (temp != null) {
            // Node currentNext = temp.next;
            // Node currentRandom = temp.random;
            
            Node deepcopy = map.get(temp);
            deepcopy.next = map.get(temp.next);
            deepcopy.random = map.get(temp.random);
            
            temp = temp.next;
        }
        
        return map.get(head);
    }
    
//     private void display(Node head) {
//         while (head != null) {
//             System.out.print(head.val + " ");
//             head = head.next;
//         }
//         System.out.println();
//     }
}