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
        ListNode dummyHead = new ListNode(-1);
        ListNode dummy = dummyHead;
        
        ListNode ptr1 = list1, ptr2 = list2;
        
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val < ptr2.val) {
                ListNode node = new ListNode(ptr1.val);
                dummy.next = node;
                ptr1 = ptr1.next;
            } else {
                ListNode node = new ListNode(ptr2.val);
                dummy.next = node;
                ptr2 = ptr2.next;
            }
            dummy = dummy.next;
        }
        
        while (ptr1 != null) {
            ListNode node = new ListNode(ptr1.val);
            dummy.next = node;
            dummy = dummy.next;
            ptr1 = ptr1.next; 
        }
        
        while (ptr2 != null) {
            ListNode node = new ListNode(ptr2.val);
            dummy.next = node;
            dummy = dummy.next;
            ptr2 = ptr2.next;
        }
        
        return dummyHead.next;
    }
}