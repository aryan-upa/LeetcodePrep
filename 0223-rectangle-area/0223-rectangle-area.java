class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
        int inty = 0;

        inty = Math.min(ay2, by2) - Math.max(ay1, by1);
        inty = inty <= 0 ? 0 : inty;
        
        int intx = 0;

        intx = Math.min(ax2, bx2) - Math.max(ax1, bx1);
        intx = intx <= 0 ? 0 : intx;
        
        return (by2 - by1) * (bx2 - bx1) + (ay2 - ay1) * (ax2 - ax1) - intx*inty;        
    }
}