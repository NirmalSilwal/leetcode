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
    /*
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
            carryover = currsum > 9 ? 1 : 0; // new carryover for next addition
            
            ListNode newNode = new ListNode(currsum % 10); // create new node
            
            dummy.next = newNode;
            dummy = dummy.next;
            
            if (rev1 != null) rev1 = rev1.next;
            if (rev2 != null) rev2 = rev2.next;
        }
        
        ListNode result = reverse(dummyHead.next);
        
        return result;
    }
    */
    
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
    
    
    // Follow up: without reversing input list
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        ListNode temp1 = l1, temp2 = l2;
        
        while (temp1 != null) {
            stack1.push(temp1.val);
            temp1 = temp1.next;
        }
        
        while (temp2 != null) {
            stack2.push(temp2.val);
            temp2 = temp2.next;
        }
        
        ListNode dummyHead = new ListNode(-1);
        ListNode dummy = dummyHead;
        int carryover = 0;
        
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            
            int currsum = stack1.pop() + stack2.pop() + carryover;
            
            dummy.next = new ListNode(currsum % 10);
            dummy = dummy.next;
            
            carryover = currsum > 9 ? 1 : 0;
        }
        
        // now see if one of the stack has left some elements
        while (!stack1.isEmpty()) {
            int currsum = stack1.pop() + carryover;
            
            dummy.next = new ListNode(currsum % 10);
            dummy = dummy.next;
            carryover = currsum > 9 ? 1 : 0;
        }
        
        while (!stack2.isEmpty()) {
            int currsum = stack2.pop() + carryover;
            
            dummy.next = new ListNode(currsum % 10);
            dummy = dummy.next;
            carryover = currsum > 9 ? 1 : 0;
        }
        
        // if last carryover is left like in test case l1=[5] and l2=[5]
        if (carryover == 1)
            dummy.next = new ListNode(1);
        
        // now reversing result
        return reverse(dummyHead.next);
    }
}