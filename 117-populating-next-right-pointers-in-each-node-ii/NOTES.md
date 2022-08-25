```
// follow up - O(1) space
public Node connect(Node root) {
if (root == null)
return root;
​
Node head = root;
// build linked list
while (head != null) {
Node dummy = new Node();
Node temp = dummy;
while (head != null) {
if (head.left != null) {
temp.next = head.left;
temp = temp.next;
}
if (head.right != null) {
temp.next = head.right;
temp = temp.next;
}
head = head.next;
}
// start from next level
head = dummy.next;
}
return root;
}
```