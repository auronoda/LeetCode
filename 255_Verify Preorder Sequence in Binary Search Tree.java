class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;
        
        for (int cur: preorder) {
            if (cur < root) {
                return false;
            }
            
            while (!stack.isEmpty() && stack.peek() < cur) {
                root = stack.pop();
            }
            stack.push(cur);
        }
        
        return true;
    }
}
