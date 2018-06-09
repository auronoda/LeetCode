class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < difficulty.length; ++i) {
            map.put(difficulty[i], Math.max(profit[i], map.getOrDefault(difficulty[i], 0)));
        }
        Arrays.sort(worker);
        Arrays.sort(difficulty);
        int res = 0;
        int i = 0;
        int max = 0;
        for (int j = 0; j < worker.length; ++j) {
            while (i < difficulty.length && difficulty[i] <= worker[j]) {
                max = Math.max(map.get(difficulty[i]), max);
                i++;
            }
            res += max;
        }
        
        return res;
    }
}
