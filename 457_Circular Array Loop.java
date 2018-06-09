class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int slow = i, fast = getNext(i, nums);
            if (slow == fast) {
                continue;
            }
            
            while (nums[fast] * nums[i] > 0 && nums[getNext(fast, nums)] * nums[i] > 0) {
                fast = getNext(fast, nums);
                fast = getNext(fast, nums);
                slow = getNext(slow, nums);
                if (slow == fast) {
                    if (slow == getNext(slow, nums)) {
                        break;
                    }
                    return true;
                }
            }
            slow = i;
            int tmp = nums[i];
            while (nums[slow] * tmp > 0) {
                int next = getNext(slow, nums);
                nums[slow] = 0;
                slow = next;
            }
            
        }
        return false;
    }

    private int getNext(int i, int[] nums) {
        int res = (i + nums[i]) % nums.length;
        return res >= 0? res: res + nums.length;
    }
}
