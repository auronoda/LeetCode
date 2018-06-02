class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        long start = lower;
        
        for (int cur: nums) {
            if (cur < start) {
                continue;
            }
            if (cur == start) {
                start += 1;
            }
            else {
                if (cur == start + 1) {
                    res.add("" + start);
                }
                else {
                    res.add("" + start + "->" + (cur - 1));
                }
                start = (long)cur + 1;
            }
        }
        
        if (start == upper) {
            res.add("" + start);
        }
        else if (start < upper) {
            res.add("" + start + "->" + upper);
        }
        
        return res;
    }
}
