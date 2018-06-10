class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }
        
        int m = image.length, n = image[0].length;
        int[][] dir = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        
        Queue<Integer> queue = new LinkedList<>();        
        queue.add(sr * n + sc);
        image[sr][sc] = newColor;
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int r = cur / n;
            int c = cur % n;
            for (int[] d: dir) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || image[nr][nc] != oldColor) {
                    continue;
                }
                queue.add(nr * n + nc);
                image[nr][nc] = newColor;
            }
        }
        return image;
    }
}
