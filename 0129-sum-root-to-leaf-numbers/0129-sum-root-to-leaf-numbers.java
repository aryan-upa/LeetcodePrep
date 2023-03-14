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
    
    int sum;
    
    public int sumNumbers(TreeNode root) {
        sum = 0;
        getNumbers(root, "");        
        return sum;
    }
    
    public void getNumbers (TreeNode root, String num) {
        if (root == null)
            return;
        
        if (root.right == null && root.left == null) {
            sum += Integer.parseInt(num + root.val);
            return;
        }
        
        getNumbers(root.left, num + root.val);
        getNumbers(root.right, num + root.val);
    }
}