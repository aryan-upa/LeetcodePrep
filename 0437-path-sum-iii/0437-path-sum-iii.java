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
	public int pathSum(TreeNode root, int targetSum) {
		if (root == null)
			return 0;
		
		int withRoot = countPathSum(root, targetSum);
		int withoutRoot = pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
		
		return withRoot + withoutRoot;
	}

	public int countPathSum(TreeNode root, long targetSum) {
		if (root == null)
			return 0;

		int ans = 0;
		if (targetSum - root.val == 0)
			ans ++;

		ans += countPathSum(root.left, targetSum - root.val) + countPathSum(root.right, targetSum - root.val);
		return ans;
	}
}