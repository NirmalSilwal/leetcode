- one approach could be using hashmap, as we traverse in LL, we put ListNode
as key in hashmap, keep traversing until null is found or same node is found in map
if null reaches then no cycle,
if some node is found while traversing on hashmap, then cycle exists
- another approach is using fast and slow pointer to reduce space to O(1)