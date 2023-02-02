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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insertIntoBSTHelper(root, val);    
    }
    
    public TreeNode insertIntoBSTHelper(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);
		
		if (root.val < val)
			root.right = insertIntoBSTHelper(root.right, val);
		else
			root.left = insertIntoBSTHelper(root.left, val);
		
		return root;
	}

}