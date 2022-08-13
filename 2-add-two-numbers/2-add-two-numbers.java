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
    
    /*
    one approach is to reverse both list l1 and l2 then sum then and reverse result
    another approach is to direclty add and forward the sum's carry towards right side
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       
        ListNode temp1 = l1, temp2 = l2;
        List<Integer> sumlist = new ArrayList<>();
        int carryover = -1;
        
        while (temp1 != null && temp2 != null) {
            
            int sum = temp1.val + temp2.val;
            int currsum = carryover == -1 ? sum : sum + carryover;
            
            if (currsum > 9) {
                sumlist.add(currsum % 10);
                carryover = 1;
            } else {
                sumlist.add(currsum);
                carryover = -1;
            }
            
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        // now of of the list could still have items if size of two list were not same
        while (temp1 != null) {
            int currsum = carryover == -1 ? temp1.val : temp1.val + carryover;
            
            if (currsum > 9) {
                sumlist.add(currsum % 10);
                carryover = 1;
            } else {
                sumlist.add(currsum);
                carryover = -1;
            }
            
            temp1 = temp1.next;
        }
        
        while (temp2 != null) {
            int currsum = carryover == -1 ? temp2.val : temp2.val + carryover;
            
            if (currsum > 9) {
                sumlist.add(currsum % 10);
                carryover = 1;
            } else {
                sumlist.add(currsum);
                carryover = -1;
            }
            
            temp2 = temp2.next;
        }
        
        if (carryover == 1)
            sumlist.add(carryover);
        
        // now making linkedlist from sumlist by traversing from head towards tail
        ListNode result = new ListNode(sumlist.get(0));
        ListNode temp = result;
        
        for (int i = 1; i < sumlist.size(); i++) {
            ListNode newNode = new ListNode(sumlist.get(i));
            temp.next = newNode;
            temp = temp.next;
        }        
        temp.next = null; // tail pointer
        
        return result;
    }
}