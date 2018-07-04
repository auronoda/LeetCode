class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        Map<Integer, Integer>[] dp = new Map[A.length];
        int res = 0;
        for (int i = 0; i < A.length; ++i) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; ++j) {
                long diff = (long)A[i] - A[j];
                if (diff < Integer.MIN_VALUE || diff > Integer.MAX_VALUE) {
                    continue;
                } 
                int sum = dp[j].getOrDefault((int)diff, 0);
                res += sum;
                dp[i].put((int)diff, dp[i].getOrDefault((int)diff, 0) + sum + 1);
            }
        }
        return res;
    }
}
