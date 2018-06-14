class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int start = 0, end = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        for (int i = 0; i < nums.size(); ++i) {
            if (nums.get(i).size() == 0) {
                continue;
            }
            max = Math.max(max, nums.get(i).get(0));
            heap.add(new int[]{i, 0, nums.get(i).get(0)});
        }
        start = heap.peek()[2];
        end = max;
        
        while (true) {
            int[] cur = heap.poll();
            if (cur[1] == nums.get(cur[0]).size() - 1) {
                break;
            }
            int next = nums.get(cur[0]).get(cur[1] + 1);
            heap.add(new int[]{cur[0], cur[1] + 1, next});
            max = Math.max(next, max);
            if (max - heap.peek()[2] < end - start) {
                end = max;
                start = heap.peek()[2];
            }
        }
        
        return new int[]{start, end};
    }
}
