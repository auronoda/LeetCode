class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {

        if (sx == tx && sy == ty) {
            return true;
        }
        if (sx > tx || sy > ty) {
            return false;
        }
        if (sx == tx) {
            return (ty - sy) % tx == 0;
        }
        if (sy == ty) {
            return (tx - sx) % ty == 0;
        }
        if (tx == ty) {
            return (sx == tx && sy == 0) || (sy == ty && sx == 0);
        }
        
        if (tx > ty) {
            return reachingPoints(sx, sy, tx - ty, ty);
        }
        return reachingPoints(sx, sy, tx, ty - tx);
    }
}
