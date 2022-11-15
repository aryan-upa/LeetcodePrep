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
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        return height(root.left)+1;
    }
    public int count(TreeNode root,int h){
        if(h<=2){
            int count=1;
            if(root.left!=null){
                count++;
            }
            if(root.right!=null){
                count++;
            }
            return count;
        }
        return count(root.left,h-1)+count(root.right,h-1)+1;
    }
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int h=height(root);
        return count(root,h);
    }
}