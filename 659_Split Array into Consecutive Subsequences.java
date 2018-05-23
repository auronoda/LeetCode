class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> tails = new HashMap<>();
        for (int cur: nums) {
            count.put(cur, count.getOrDefault(cur, 0) + 1);
        }
        
        for (int cur: nums) {
            if (count.get(cur) == 0) {
                continue;
            }
            
            if (tails.getOrDefault(cur, 0) > 0) {
                tails.put(cur + 1, tails.getOrDefault(cur + 1, 0) + 1);
                tails.put(cur, tails.get(cur) - 1);
            }
            
            else if (count.getOrDefault(cur + 1, 0) > 0 && count.getOrDefault(cur + 2, 0) > 0) {
                count.put(cur + 1, count.get(cur + 1) - 1);
                count.put(cur + 2, count.get(cur + 2) - 1);
                tails.put(cur + 3, tails.getOrDefault(cur + 3, 0) + 1);
            }
            else {
                return false;
            }
            
            count.put(cur, count.get(cur) - 1);
            
        }
        return true;
    }
}
