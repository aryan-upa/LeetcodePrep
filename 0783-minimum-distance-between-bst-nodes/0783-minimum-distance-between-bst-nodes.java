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
    
    static int minDiff;
    TreeNode prevNode;
    
	public int minDiffInBST(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        inorderTraversal(root);    
        return minDiff;
	}
    
    private void inorderTraversal (TreeNode node) {
        if (node == null)
            return;
        
        inorderTraversal(node.left);
        
        if (prevNode != null)
            minDiff = Math.min(minDiff, node.val - prevNode.val);
        
        prevNode = node;
        inorderTraversal(node.right);
    }
    
}
