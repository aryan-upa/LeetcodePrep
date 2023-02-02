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
		CameraData rootData = createCameraData(root);
        
        if (rootData.status == -1)
            count += 1;

        return count;
	}

	public CameraData createCameraData (TreeNode root) {
		if (root == null)
			return new CameraData(null);

		CameraData left = createCameraData (root.left);
		CameraData right = createCameraData (root.right);

		CameraData node = new CameraData(root);
		
		if (left.status == -1 || right.status == -1) {
			count += 1;
			node.status = 0;
		} 
		else if (left.status == 1 && right.status == 1) {
			node.status = -1;
		} 
		else {
			node.status = 1;
		}
		
		return node;
	}
}