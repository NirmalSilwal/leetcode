- first idea that come to mind is doing DFS traversal like in finding height of tree -recursive solution
- when it comes to find maximum depth go with DFS and for minimum depth use BFS.
​
1ST code draft - but wrong solution
```
public int minDepth(TreeNode root) {
if (root == null) return 0;
return findDepth(root);
}
private int findDepth(TreeNode root) {
if (root == null) return 0;
if (root.left == null && root.right == null) // leaf node
return 1;
int leftDepth = 1 + findDepth(root.left);
int rightDepth = 1 + findDepth(root.right);
return Math.min(leftDepth, rightDepth);
}
```
​
2ND coding approach is using queue in our **breadth first search** traversal way
​
​
​
​
​