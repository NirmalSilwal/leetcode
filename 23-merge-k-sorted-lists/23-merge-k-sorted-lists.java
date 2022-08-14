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
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // adding all node value of all k lists into min heap so 
        // minimum value node will always be at top at any point in time
        
        for (ListNode currList : lists) {
            // now add all nodes of currList into heap
            while (currList != null) {
                // traverse currList and insertion in minHeap
                minHeap.add(currList.val);
                currList = currList.next;
            }
        }
        
        ListNode dummyHead = new ListNode(-1);
        ListNode dummy = dummyHead;
        
        while (!minHeap.isEmpty()) {
            dummy.next = new ListNode(minHeap.remove());
            dummy = dummy.next;
        }
        
        return dummyHead.next;
    }
}