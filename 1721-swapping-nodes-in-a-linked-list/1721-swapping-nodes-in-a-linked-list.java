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
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int arr[] = findLengthAndFirstValue(head, k);
        int len = arr[0], first = arr[1];
        int lastIndex = len - k + 1;

        // finding value of node in kth node from end
        ListNode temp = head;
        int count = 1;
        while (count != lastIndex && temp != null) {
            temp = temp.next;
            count++;
        }
        int last = temp.val; // value of kth node from start

        // swap first and last
        temp = head;
        int currCount = 1;
        while (temp != null) {
            if (currCount == k) {
                temp.val = last;
            }
            if (currCount == lastIndex) {
                temp.val = first;
            }
            currCount++;
            temp = temp.next;;
        }

        return head;

    }

    private static int[] findLengthAndFirstValue(ListNode head, int k) {
        int[] ans = new int[2];
        int len = 0;
        int index = 0;

        while (head != null) {
            len++;
            index++;
            if (index == k) {
                ans[1] = head.val;
            }
            head = head.next;
        }
        ans[0] = len; // value of kth node from first
        return ans;
    }
}