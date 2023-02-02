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
	static class BST_Pair {
		boolean isBST = true;
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;
	}

	public boolean isValidBST(TreeNode root) {
		return getBSTPair(root).isBST;
	}
	
	public BST_Pair getBSTPair (TreeNode root) {
		if (root == null)
			return new BST_Pair();
		
		BST_Pair left = getBSTPair(root.left);
		BST_Pair right = getBSTPair(root.right);
		
		BST_Pair self = new BST_Pair();

		self.min = Math.min(left.min, Math.min(right.min, root.val));
		self.max = Math.max(left.max, Math.max(right.max, root.val));
		self.isBST = left.isBST && right.isBST && left.max < root.val && right.min > root.val;

		return self;
	}
}