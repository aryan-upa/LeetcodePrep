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
    public int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return 0;
        
        return maxDiffInPath(root, root.val, root.val);
    }

    public int maxDiffInPath(TreeNode root, int max, int min) {
        if (root == null)
            return max - min;
        
        max = Math.max(root.val, max);
        min = Math.min(root.val, min);

        int l = maxDiffInPath(root.left, max, min);
        int r = maxDiffInPath(root.right, max, min);

        return Math.max(l, r);
    }
}