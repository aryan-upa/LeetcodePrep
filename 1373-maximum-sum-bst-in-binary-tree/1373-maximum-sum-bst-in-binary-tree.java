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
    public int maxSumBST(TreeNode root) {
        return getAllData(root).ans;
    }
    
    static class NodeInfo {
		int sum;
		int ans;
		boolean isBST;
		int min;
		int max;

		NodeInfo () {
            isBST = true;
            sum = 0;
            ans = 0;
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
		}    
    }

    public int getManyMax(int...args) {
		int max = Integer.MIN_VALUE;
		for (int val : args)  max = Math.max(max, val);
		return max;
	}

	public NodeInfo getAllData (TreeNode root) {
		if (root == null)
			return new NodeInfo();

		NodeInfo left = getAllData(root.left);
		NodeInfo right = getAllData(root.right);

		NodeInfo self = new NodeInfo();

		self.min = Math.min(left.min, Math.min(right.min, root.val));
		self.max = Math.max(left.max, Math.max(right.max, root.val));
		self.sum = left.sum + right.sum + root.val;

		if (left.isBST && right.isBST && left.max < root.val && right.min > root.val) {
			self.isBST = true;
			self.ans = getManyMax (left.ans, right.ans, self.sum);
		} else {
			self.isBST = false;
			self.ans = getManyMax (left.ans, right.ans);
		}

		return self;
	}

}