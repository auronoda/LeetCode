class Solution {
    public int minMoves2(int[] nums) {
        int[] tmp = nums.clone();
        Arrays.sort(tmp);
        int mid = tmp[(tmp.length - 1) / 2];
        int res = 0;
        for (int cur: tmp) {
            res += Math.abs(cur - mid);
        }
        return res;
    }
}
