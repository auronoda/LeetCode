class Solution {
    public int preimageSizeFZF(int K) {
        return (int)(bs(K + 1) - bs(K));
    }
    
    private long bs(int K) {
        long start = 0, end = Long.MAX_VALUE;
        while (start < end) {
            long mid = start + (end - start) / 2;
            if (count(mid) >= K) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        System.out.println(start);
        return start;
    }
    
    private long count(long i) {
        long res = 0;
        while (i >= 5) {
            res += i / 5;
            i /= 5;
        }
        return res;
    }
}
