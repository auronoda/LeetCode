class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        int mod = 1000000007;
        Map<Integer, Long> map = new HashMap<>();
        long res = 0;
        
        for (int i = 0; i < n; ++i) {
            long tmp = 1;
            for (int j = 0; j < i; ++j) {
                if (A[i] % A[j] == 0 && map.containsKey(A[i] / A[j])) {
                    tmp = (tmp + map.get(A[j]) * map.get(A[i] / A[j])) % mod;
                }
            }
            
            map.put(A[i], tmp);
            res = (res + tmp) % mod;
        }
        return (int)res;
    }
}
