**1st draft of thoughts**
​
```
class Solution {
public TreeNode buildTree(int[] preorder, int[] inorder) {
TreeNode root = new TreeNode(preorder[0]);
TreeNode curr = root; // dummy node
int rootIndex = findNodeIndex(preorder[0], inorder);
TreeNode leftSubtree = constructSubtree(0, rootIndex, inorder);
TreeNode rightSubtree = constructSubtree(rootIndex + 1, inorder.length, inorder);
root.left = leftSubtree;
root.right = rightSubtree;
return root;
}
private TreeNode constructSubtree(int left, int right, int[] inorder) {
if (right - left == 1)
return new TreeNode(inorder[left]); // if single node between left and right position
// TODO
}
private int findNodeIndex(int nodeValue, int[] traversal) {
for (int i = 0; i < traversal.length; i++) {
if (traversal[i] == nodeValue)
return i;
}
return -1;
}
}
```