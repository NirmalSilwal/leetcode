/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /*
        if you have camera return 0
        if you need camera return -1
        if you don't need camera and is covered by either your parent or child, return 1
        do the post order tree traversal: LRN (left, right, node visit)
    */
    
    int camera = 0;
    public int minCameraCover(TreeNode root) {     
        if (totalCameraRequired(root) == -1) 
            camera++; // if camera is needed
        return camera;
    }
    
    /*  if node is leaf, it will return 1 to it's parent.
        null will also return 1 as it is covered, so if both left and right child
        returns 1, then it's parent will return -1 to it's parent saying I need camera
        as I don't have camera and my child don't cover me
    */
    private int totalCameraRequired(TreeNode root) {
        
        if (root == null)
            return 1; // I'm covered, i don't need camera, this will handle leaf node also
        
        int leftchild = totalCameraRequired(root.left);
        int rightchild = totalCameraRequired(root.right);
        
        // if either child needs camera
        if (leftchild == -1 || rightchild == -1) {
            camera++;
            return 0; // now I have camera so returning 0 to my parent
        }
        
        // if both don't need camera, it means either it has camera or it is covered
        if (leftchild == 0 || rightchild == 0) {
               return 1; // i'm covered by one of my child so returning 1
        }
        
        // now since both of my child don't need camera, I need to be covered so 
        // my parent you've to look after me so I'm returning -1 saying I need camera
        return -1; 
    }

}