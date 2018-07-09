class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> (a[0] == b[0]? a[1] - b[1]: a[0] - b[0]));
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        int res = 0;
        for (int[] cur: points) {
            if (heap.isEmpty() || heap.peek()[1] < cur[0]) {
                res++;
                heap.add(cur);
            }
            else {
                int[] overlap = heap.poll();
                overlap[0] = Math.max(overlap[0], cur[0]);
                overlap[1] = Math.min(overlap[1], cur[1]);
                heap.add(overlap);
            }
        }
        return res;
    }
}
