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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        // swap values of node in slow and fast position in list
        while (fast != null && fast.next != null) {
            swap(slow, fast);
            slow = fast.next;
            fast = fast.next.next;
        }
        swap(slow, fast);
        
        return head;
    }

    private static void swap(ListNode slow, ListNode fast) {
        if (slow == null || fast == null) return;
        int tempValue = slow.val;
        slow.val = fast.val;
        fast.val = tempValue;
    }
}