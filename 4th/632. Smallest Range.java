class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        int[] idxs = new int[k];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b) -> (nums.get(a).get(idxs[a]) - nums.get(b).get(idxs[b])));
        
        for (int i = 0; i < k; ++i) {
            int cur = nums.get(i).get(idxs[i]);
            min = Math.min(min, cur);
            max = Math.max(max, cur);
            heap.add(i);
        }
        int[] res = new int[]{min, max};
        while (true) {
            int i = heap.poll();
            if (idxs[i] == nums.get(i).size() - 1) {
                break;
            }
            idxs[i]++;
            int next = nums.get(i).get(idxs[i]);
            max = Math.max(max, next);
            heap.add(i);
            int j = heap.peek();
            min = nums.get(j).get(idxs[j]);
            if(max - min < res[1] - res[0] || (max - min == res[1] - res[0] && min < res[0])) {
                res[0] = min;
                res[1] = max;
            }
        }
        
        return res;
    }
}
