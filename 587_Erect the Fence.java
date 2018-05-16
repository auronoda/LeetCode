/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public List<Point> outerTrees(Point[] points) {
        if (points.length <= 3) {
            return Arrays.asList(points);
        }
        
        Point tmp = points[0];
        for (Point cur: points) {
            if (tmp.y > cur.y) {
                tmp = cur;
            }
        }
        
        final Point bm = tmp;
        
        Arrays.sort(points, new Comparator<Point>(){
            public int compare(Point q, Point r){
                int res = orientation(bm, q, r);
                if (res == 0) {
                    return dis(q, bm) - dis(r, bm);
                }
                return res;
            }
        });
        
        int j = points.length - 1;
        while (j >= 0 && orientation(bm, points[points.length - 1], points[j]) == 0)
            j--;
        for (int l = j + 1, h = points.length - 1; l < h; l++, h--) {
            Point temp = points[l];
            points[l] = points[h];
            points[h] = temp;
        }
        
        Stack<Point> stack = new Stack<>();
        stack.push(points[0]);
        stack.push(points[1]);
        for (int i = 2; i < points.length; ++i) {
            Point cur = points[i];
            Point top = stack.pop();
            while (orientation(stack.peek(), top, cur) > 0) {
                top = stack.pop();
            }
            stack.push(top);
            stack.push(cur);
        }
        
        return new ArrayList<Point>(stack);
    }
    
    private int orientation(Point p, Point q, Point r){
        return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    }
    
    private int dis(Point p, Point q){
        return (q.y - p.y) * (q.y - p.y) + (q.x - p.x) * (q.x - p.x);
    }
}
