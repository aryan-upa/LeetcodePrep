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
    public int sumNumbers(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        getNumbers(root, list, "");
        
        int sum = 0;
        for (String num : list)
            sum += Integer.parseInt(num);
        return sum;
    }
    
    public void getNumbers (TreeNode root, ArrayList<String> list, String num) {
        if (root == null)
            return;
        
        if (root.right == null && root.left == null) {
            list.add(num + root.val);
            return;
        }
        
        getNumbers(root.left, list, num + root.val);
        getNumbers(root.right, list, num + root.val);
    }
}