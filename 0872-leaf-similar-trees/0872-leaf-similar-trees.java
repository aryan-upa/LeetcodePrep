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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<String> tree1 = new ArrayList<>();
        dfs(root1, tree1);
        ArrayList<String> tree2 = new ArrayList<>();
        dfs(root2, tree2);

        return compare(tree1, tree2);
    }

    public void dfs(TreeNode root, ArrayList<String> list) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            list.add("" + root.val);
        }

        dfs(root.left, list);
        dfs(root.right, list);
    }

    public boolean compare (ArrayList<String> l1, ArrayList<String> l2) {
        if (l1.size() != l2.size())
            return false;

        for (int i = 0; i < l1.size(); i ++) {
            if (!l1.get(i).equals(l2.get(i)))
                return false;
        }

        return true;
    }
}