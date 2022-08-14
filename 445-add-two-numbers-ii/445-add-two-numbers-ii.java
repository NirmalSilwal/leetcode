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
    // approach 1 - by reversing both list and reversing result list also
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode rev1 = reverse(l1);
        ListNode rev2 = reverse(l2);
        int carryover = 0;
        ListNode dummyHead = new ListNode(-1);
        ListNode dummy = dummyHead;
        
        while (rev1 != null || rev2 != null || carryover != 0) {
            int currsum = 0;   
            if (rev1 != null) {
                currsum += rev1.val;
            }            
            if (rev2 != null) {
                currsum += rev2.val;
            }            
            currsum += carryover;
            
            // new carryover for next addition, 
            // since input range is 0 to 9, max sum will be 9 + 9 = 18, so carryover will be either 1 or 0
            carryover = currsum > 9 ? 1 : 0; 
            
            ListNode newNode = new ListNode(currsum % 10); // create new node
            
            dummy.next = newNode;
            dummy = dummy.next;
            
            if (rev1 != null) rev1 = rev1.next;
            if (rev2 != null) rev2 = rev2.next;
        }
        
        ListNode result = reverse(dummyHead.next);
        
        return result;
    }
    
    // reverse linkedlist
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode prev = null, curr = head, nxt = head.next;
        
        while (curr.next != null) {
            curr.next = prev;
            prev = curr;
            curr = nxt;
            nxt = nxt.next;
        }
        curr.next = prev;
        head = curr;
        
        return head;
    }
}