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
    public ListNode reverseList(ListNode head) {
        
        if (head == null || head.next == null) return head;

        ListNode prev = null, curr = head, future = head.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = future;
            if (future != null) future = future.next;
        }

        return prev;
    }
}