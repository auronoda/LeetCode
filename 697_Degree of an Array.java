class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int max = 0;
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            int cur = nums[i];
            if (!map.containsKey(cur)) {
                map.put(cur, new int[]{1, i});
            }
            else {
                map.get(cur)[0]++;
            }
            if (map.get(cur)[0] > max) {
                res = i - map.get(cur)[1] + 1;
                max = map.get(cur)[0];
            }
            else if (map.get(cur)[0] == max) {
                res = Math.min(res, i - map.get(cur)[1] + 1);
            }
        }
        return res;
    }
}
