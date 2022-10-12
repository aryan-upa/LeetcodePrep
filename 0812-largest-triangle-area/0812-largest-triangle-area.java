class Solution {
static double maxArea = 0;

	public double largestTriangleArea(int[][] points) {
		maxArea = 0;
		getAreaPerCombination(points, 0, new int[3][2], 0);
		return maxArea;
	}

	private void getAreaPerCombination(int[][] points, int currentPoint, int[][] triangle, int currI) {
		if (currentPoint == 3) {
			// System.out.println(Arrays.deepToString(triangle));
			double area = getTriangleArea(triangle);
			maxArea = Math.max(maxArea, area);
			return;
		}

		for (int i = currI; i < points.length; i ++) {
			triangle[currentPoint] = points[i];
			getAreaPerCombination(points, currentPoint + 1, triangle, i + 1);
			triangle[currentPoint] = null;
		}
	}

	private double getTriangleArea(int[][] triangle) {
		int[] p1 = triangle[0], p2 = triangle[1], p3 = triangle[2];
		return (double) Math.abs(p1[0]*(p2[1] - p3[1]) + p2[0]*(p3[1] - p1[1]) + p3[0]*(p1[1] - p2[1])) / 2.0;
	}
}