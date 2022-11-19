class Solution {
	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int[][] outerTrees(int[][] trees) {
        if (trees.length <= 3)
            return trees;

        Point[] points = new Point[trees.length];
		int i = 0;

		for (int[] tree : trees)
			points[i++] = new Point(tree[0], tree[1]);

		int leftMostIndex = leftMostIndex(points);
		HashSet<Point> hull = new HashSet<>();

		int p = leftMostIndex, q;
        boolean isChanged = false;
        
		do {
			q = (p + 1) % trees.length; // to visit the array in circular form

			for (i = 0; i < points.length; i ++) {
			    if (orientation(points[p], points[i], points[q]) < 0)
					q = i;
            }

            for (i = 0; i < points.length; i ++) {
			    if (i != p && i!= q && collinearAndInBetween(points[p], points[i], points[q]))
					hull.add(points[i]);
            }

            int prevSize = hull.size();
            hull.add(points[q]);  
            
            isChanged = prevSize < hull.size();

            p = q;
        } while (p != leftMostIndex && isChanged);

		int[][] res = new int[hull.size()][2];
		i = 0;
		for (Point poi : hull)
			res[i++] = new int[]{poi.x, poi.y};

		return res;
	}

	public int orientation(Point a, Point b, Point c) {
		return (b.y - a.y)*(c.x - b.x) - (c.y - b.y)*(b.x - a.x);
		// 0 - collinear, -ive - counter-clockwise, +ive - clockwise
	}

	public int leftMostIndex(Point[] points) {
		int res = 0;

		for (int i = 0; i < points.length; i ++)
			if (points[i].x < points[res].x)
				res = i;

		return res;
	}
    
    public boolean collinearAndInBetween(Point a, Point b, Point c) {
        boolean b1 = b.x >= a.x && b.x <= c.x || b.x <= a.x && b.x >= c.x;
        boolean b2 = b.y >= a.y && b.y <= c.y || b.y <= a.y && b.y >= c.y;

        return orientation(a,b,c) == 0 && b1 && b2;
    }
}




