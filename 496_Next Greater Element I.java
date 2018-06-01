class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; ++i) {
            map.put(nums2[i], i);
        }
        
        int[] next = new int[nums2.length];
        Arrays.fill(next, -1);
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < nums2.length; ++i) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                next[stack.pop()] = nums2[i];
            }
            stack.push(i);
        }
        
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = next[map.get(nums1[i])];
        }
        
        return res;
    }
}
