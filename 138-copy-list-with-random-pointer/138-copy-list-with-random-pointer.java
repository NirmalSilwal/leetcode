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
    // O(N) Time, O(N) space
    /*
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
            
            Node deepcopy = map.get(temp);
            deepcopy.next = map.get(temp.next);
            deepcopy.random = map.get(temp.random);
            
            temp = temp.next;
        }
        
        return map.get(head);
    }
    */
    
    // optimal approach- O(N) time, O(1) space
    
     public Node copyRandomList(Node head) {
        if (head == null) return head;
         
         // 1st make deep copy of each node with next of original node pointing to its deep copy
         // and next of deep copy pointing to next of current original node
         
         Node temp = head;
         while (temp != null) {
             Node front = temp.next;
             
             Node deepcopy = new Node(temp.val);
             temp.next = deepcopy;
             deepcopy.next = front;
            
             temp = front;
         }
         
         // adjust random pointer in deepcopy
         temp = head;
         while (temp != null) {
             // as current node points to deep copy and
             // deep copy next is pointing to current pointer next in original position
             Node front = temp.next.next; 
             
             // random pointer of deepcopy = random of current node 
             // and next will point to deep copy of random node
             if (temp.random != null) 
                temp.next.random = temp.random.next; // this adjusts random ptr in deepcopy node
             
             temp = front; // temp = temp.next step as usual
         }
         
         // lastly, adjust the next pointer in original list as well as in deepcopy
         Node dummyHead = new Node(-1);
         Node dummy = dummyHead;
         temp = head;
         
         while (temp != null) {
             Node front = temp.next.next;
             dummy.next = temp.next;
             
             temp.next = front;
             
             dummy = dummy.next;
             temp = front;
         }
         
         return dummyHead.next;
     }
    
}