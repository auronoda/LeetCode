class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        int max = 0;
        for (int i = 0; i < stations.length - 1; ++i) {
            max = Math.max(max, stations[i + 1] - stations[i]);
        }
        
        double start = 0, end = max;
        while (end - start > 1e-6) {
            double mid = start + (end - start) / 2;
            if (possible(stations, K, mid)) {
                end = mid;
            }
            else {
                start = mid + 1e-6;
            }
        }
        return start;
    }
    
    private boolean possible(int[] stations, int K, double dis) {
        int left = K;
        for (int i = 0; i < stations.length - 1; ++i) {
            left -= (int)((stations[i + 1] - stations[i]) / dis);
            if (left < 0) {
                return false;
            }
        }
        return true;
    }
}
