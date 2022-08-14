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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        
        ListNode temp1 = list1, temp2 = list2;
        ListNode dummy = new ListNode(-1);
        ListNode dummyHead = dummy;
        
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                dummyHead.next = temp1;
                temp1 = temp1.next;
            } else {
                dummyHead.next = temp2;
                temp2 = temp2.next;
            }
            dummyHead = dummyHead.next;   
        }
        
        if (temp1 != null) {
            dummyHead.next = temp1;
        } else if (temp2 != null) {
            dummyHead.next = temp2;
        }
        
        return dummy.next;
    }
}