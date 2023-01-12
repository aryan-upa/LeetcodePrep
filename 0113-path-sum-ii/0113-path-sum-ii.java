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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        getAllPathSum(root, targetSum, new ArrayList<>(), res);
        return res;
    }
    
    public void getAllPathSum(TreeNode node, int targetSum, ArrayList<Integer> list, List<List<Integer>> res) {
        if (node == null) 
            return;
        
        if (node.left == null && node.right == null && targetSum - node.val == 0) {
            list.add(node.val);
            res.add(List.copyOf(list));
            list.remove(list.size() - 1);
            return;
        }
        
        list.add(node.val);
        targetSum = targetSum - node.val;

        getAllPathSum(node.left, targetSum, list, res);
        getAllPathSum(node.right, targetSum, list, res);
        
        list.remove(list.size() - 1);
    }
}