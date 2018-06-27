class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int cur: nums) {
            queue.add(cur);
            if (queue.size() > k + 1) {
                set.remove(queue.poll());
            }
            if (!set.add(cur)) {
                return true;
            }
        }
        return false;
    }
}
