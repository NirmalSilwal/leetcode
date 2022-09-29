/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // approach 1 using two pass, one for finding total nodes
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if (head == null) return head;
        
        if (head.next == null && n == 1) return null;
        
        int totalNodes = 0;
        ListNode temp = head;
        
        while (temp != null) {
            totalNodes++;
            temp = temp.next;
        }
        
        // if removing 1st node in the list
        if (totalNodes == n)
            return head.next;
        
        int removePos = totalNodes - n;
        
        temp = head;
        // moving cursor to that required position
        for (int i = 1; i < removePos; i++) {
            temp = temp.next;
        }
        // removing node
        temp.next = temp.next.next;
            
        return head;
    }
}