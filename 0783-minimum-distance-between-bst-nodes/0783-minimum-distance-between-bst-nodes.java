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
	public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorderTraversal (root, list);
        
        int len = list.size();
        int dif = Integer.MAX_VALUE;

        for (int i = 1; i < len; i ++)
            dif = Math.min(dif, list.get(i) - list.get(i-1));
        
        return dif;
	}
    
    private void inorderTraversal (TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }
    
}
