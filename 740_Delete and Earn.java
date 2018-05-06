class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] vals = new int[10001];
        
        for (int cur: nums) {
            vals[cur] += cur;
        }
        
        int take = 0;
        int skip = 0;
        for (int i = 1; i <= 10000; i++) {
            int newSkip = Math.max(take, skip);
            take = skip + vals[i];
            skip = newSkip;
        }
        return Math.max(take, skip);
    }
}
