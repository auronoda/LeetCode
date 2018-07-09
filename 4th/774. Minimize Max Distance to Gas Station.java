class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        int[] dis = new int[stations.length - 1];
        int max = 0;
        for (int i = 1; i < stations.length; ++i) {
            dis[i - 1] = stations[i] - stations[i - 1];
            max = Math.max(max, dis[i - 1]);
        }
        double start = 1e-6, end = max;
        while (end - start >= 1e-6) {
            double mid = start + (end - start) / 2;
            if (valid(dis, mid, K)) {
                end = mid;
            }
            else {
                start = mid + 1e-6;
            }
        }
        return start;
    }
    
    private boolean valid(int[] dis, double mid, int K) {
        for (int cur: dis) {
            K -= (int)Math.ceil((double)cur / mid) - 1;
        }
        return K >= 0;
    }
}
