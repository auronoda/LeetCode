class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Queue<Integer> queue = new LinkedList<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int cur: nums) {
            queue.add(cur);
            if (queue.size() > k + 1) {
                set.remove(queue.poll());
            }
            if ((set.floor(cur) != null && (long)cur - set.floor(cur) <= t) || (set.ceiling(cur) != null && (long)set.ceiling(cur) - cur <= t)) {
                return true;
            }
            set.add(cur);
        }
        return false;
    }
}
