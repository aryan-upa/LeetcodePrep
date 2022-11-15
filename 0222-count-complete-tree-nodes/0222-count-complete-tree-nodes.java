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
    public int height(TreeNode root) {
        return root == null ? 0 : height(root.left) + 1; 
    }

    public int count(TreeNode root, int h){
        if (h <= 2) {
            int count=1;
            count += root.left!=null ? 1 : 0;
            count += root.right!=null ? 1 : 0;
            return count;
        }

        int left = count(root.left, h-1);
        int right = count(root.right,h-1);
        return 1 + left + right;
    }

    public int countNodes(TreeNode root) {
        if(root==null) return 0;

        int h = height(root);
        return count(root,h);
    }
}