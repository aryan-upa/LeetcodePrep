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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
		return createTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
	}
	
	public TreeNode createTree(int[] inorder, int iLow, int iHigh, int[] preorder, int pLow, int pHigh) {
		if (iLow > iHigh || pLow > pHigh)
			return null;
		
		TreeNode node = new TreeNode(preorder[pLow]);
		
		int index = search(inorder, iLow, iHigh, preorder[pLow]);
		int net = index - iLow;
		
		node.left = createTree(inorder, iLow, index - 1, preorder, pLow + 1, pLow + net);
		node.right = createTree(inorder, index + 1, iHigh, preorder, pLow + net + 1, pHigh);
		
		return node;
	}
	
	public int search(int[] inorder, int iLow, int iHigh, int item) {
		for (int i = iLow; i <= iHigh; i ++)
			if (inorder[i] == item)
				return i;
		return -1;
	}

}