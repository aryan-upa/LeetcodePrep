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
    public int maxPathSum(TreeNode root) {
        return (int) findMaxPath(root).maxVal;
    }

	public static long getManyMax (long...args) {
		long val = Long.MIN_VALUE;
		for (long v : args) val = Math.max(v, val);
		return val;
	}

	private static class NodeDataContainer<T> {
		long maxUpto = 0; // possible maximum value, but contains only one path which ends at the current node.
		long maxVal = Integer.MIN_VALUE; // possible maximum value, but may or may not contain the current node.
	}

	public static NodeDataContainer<TreeNode> findMaxPath (TreeNode root) {
		if (root == null)
			return new NodeDataContainer<>();

		NodeDataContainer<TreeNode> left = findMaxPath(root.left);
		NodeDataContainer<TreeNode> right = findMaxPath(root.right);
		NodeDataContainer<TreeNode> thisNode = new NodeDataContainer<>();

		long maxUpto = getManyMax(root.val, root.val + Math.max(left.maxUpto, right.maxUpto));
		long maxVal = getManyMax(left.maxVal, right.maxVal, left.maxUpto + root.val + right.maxUpto, maxUpto);

		thisNode.maxUpto = maxUpto;
		thisNode.maxVal = maxVal;

		return thisNode;
	}
}
