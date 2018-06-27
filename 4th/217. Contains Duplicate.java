class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int cur: nums) {
            if (!set.add(cur)) {
                return true;
            }
        }
        return false;
    }
}
