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
        getNumbers(root, 0);        
        return sum;
    }
    
    public void getNumbers (TreeNode root, int num) {
        if (root == null) return;
        
        int currSum = num*10 + root.val;
        
        if (root.right == null && root.left == null) {
            sum += currSum;
            return;
        }
        
        getNumbers(root.left, currSum);
        getNumbers(root.right, currSum);
    }
}