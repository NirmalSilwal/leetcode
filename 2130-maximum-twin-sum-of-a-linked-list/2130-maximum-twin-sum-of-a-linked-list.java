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
    public int pairSum(ListNode head) {
        
        int n = 0; // total number of nodes in list
        ListNode temp = head;
        Map<Integer, Integer> indexValueMap = new HashMap(); // key is index, value is node value

        while (temp != null) {
            indexValueMap.put(n++, temp.val);
            temp = temp.next;
        }

        int maxSum = 0;
        int endRange = (n / 2) - 1; // i can be in 0 to endRange

        for (int i = 0; i <= endRange; i++) {
            // finding twin for ith index
            int twinIndex = n - i - 1;
            int currentTwinSum = indexValueMap.get(i) + indexValueMap.get(twinIndex);
            
            maxSum = Math.max(maxSum, currentTwinSum);
        }

        return maxSum;

    }
}