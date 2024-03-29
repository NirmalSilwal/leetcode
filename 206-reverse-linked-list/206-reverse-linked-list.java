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
    public ListNode reverseListIterative(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode prev = null, curr = head, nxt = head.next;
        
        while (curr.next != null) {
            curr.next = prev;
            prev = curr;
            curr = nxt;
            
            if (nxt != null)
                nxt = nxt.next;
        }
        curr.next = prev;
        head = curr;
        
        return head;
    }
        
    // follow-up : recursive solution
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode remainingAnswer = reverseList(head.next);
        
        head.next.next = head;
        head.next = null;
        
        return remainingAnswer;
    }

}