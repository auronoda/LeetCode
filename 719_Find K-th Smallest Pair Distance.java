class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> counts = new LinkedList(map.entrySet());
        Collections.sort(counts, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return a.getKey() - b.getKey();
            }
        });
        
        int zeroCount = 0;
        int preCount = 0;
        TreeMap<Integer, Integer> pre = new TreeMap<>();
        for (Map.Entry<Integer, Integer> cur: counts) {
            zeroCount += (cur.getValue() - 1) * cur.getValue() / 2;
            preCount += cur.getValue();
            pre.put(cur.getKey(), preCount);
        }

        
        int start = 0, end = counts.get(counts.size() - 1).getKey() - counts.get(0).getKey();
        int mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            System.out.println(mid);
            int count = zeroCount;            
            for (Map.Entry<Integer, Integer> cur: counts) {
                int num = cur.getKey();
                count += (pre.get(pre.floorKey(num + mid)) - pre.get(num)) * cur.getValue();                
            }
            System.out.println(count);
            if (count >= k) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }
}
