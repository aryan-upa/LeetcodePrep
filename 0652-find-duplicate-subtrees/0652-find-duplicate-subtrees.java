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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        traverse(root, new HashMap<>(), res);
        return res;
    }

    public String traverse (TreeNode node, Map<String, Integer> cnt, List<TreeNode> res) {
        if (node == null)
            return "";

        String left = "<" + traverse(node.left, cnt, res) + ">" ;
        String right = "<" + traverse(node.right, cnt, res) + ">";
        
        String representation = left + node.val + right;
        cnt.put(representation, cnt.getOrDefault(representation, 0) + 1);
        
        // System.out.println(representation);
        if (cnt.get(representation) == 2)
            res.add(node);

        return representation;
    }
}