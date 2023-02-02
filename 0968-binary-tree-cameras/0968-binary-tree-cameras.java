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
    
	int count = 0;

	static class CameraData {
		TreeNode node;
		int status = 1;

		CameraData (TreeNode node) {
			this.node = node;
		}
        
        /*
            status key:
            1 : covered
            0 : camera fit
            -1: required
        */
	}

	public int minCameraCover(TreeNode root) {
        int rootStatus = createCamera(root);
        
        if (rootStatus == -1)
            count += 1;

        return count;
	}

	public int createCamera (TreeNode root) {
		if (root == null)
			return 1;
		
		int leftStatus = createCamera(root.left);
		int rightStatus = createCamera(root.right);
		
		if (leftStatus == -1 || rightStatus == -1) {
			count += 1;
			return 0;
		}
		else if (leftStatus == 1 && rightStatus == 1)
			return -1;
		else
			return 1;
	}
}