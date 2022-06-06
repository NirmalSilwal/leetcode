/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    // O(m+n) time, O(N) space 
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        Map<ListNode, Integer> map = new HashMap<>();
        
        // storing all nodes of 1st list in hashmap
        while (temp1 != null) {
            map.put(temp1, temp1.val);
            temp1 = temp1.next;
        }
        
        // traverse 2nd list and see if it's node is already in hashmap
        while (temp2 != null) {
            if (map.containsKey(temp2))
                return temp2;
            temp2 = temp2.next;
        }
        // if node is not found in hashmap already it means there is no intersection
        return null;
    }
}