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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return levelOrderZZ(root);
    }
    
    public List<List<Integer>> levelOrderZZ (TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return res;
        

        queue.add(root);
        Deque<TreeNode> helper = new LinkedList<>();
        boolean lTR = true;
        while (!queue.isEmpty()) {
            TreeNode remove = lTR ? queue.removeFirst() : queue.removeLast();
            list.add(remove.val);

            if (lTR) {
                if (remove.left != null) helper.addLast(remove.left);
                if (remove.right != null) helper.addLast(remove.right);
            }

            else {
                if (remove.right != null) helper.addFirst(remove.right);
                if (remove.left != null) helper.addFirst(remove.left);
            }

            if (queue.isEmpty()) {
                lTR = !lTR;
                queue = helper;
                helper = new LinkedList<>();
                res.add(list);
                list = new ArrayList<>();
            }
        }
        
        return res;
    }
}