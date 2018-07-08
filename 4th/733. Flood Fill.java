class Solution {
    int[][] dir = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }
        int m = image.length, n = image[0].length;
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }
        Queue<Integer> queue = new LinkedList<>();
        image[sr][sc] = newColor;
        queue.add(sr * n + sc);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int r = cur / n, c = cur % n;
            for (int[] d: dir) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n || image[nr][nc] != oldColor) {
                    continue;
                }
                image[nr][nc] = newColor;
                queue.add(nr * n + nc);
            }
        }
        return image;
    }
}
