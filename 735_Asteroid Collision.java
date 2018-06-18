class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int cur: asteroids) {
            if (cur > 0) {
                stack.push(cur);
            }
            else {
                boolean ex = false;
                while (!stack.isEmpty() && stack.peek() > 0) {
                    int right = stack.peek();
                    if (right <= -cur) {
                        stack.pop();
                    }
                    if (right >= -cur) {
                        ex = true;
                        break;
                    }
                }
                if (!ex) {
                    stack.push(cur);
                }
            }
        }
        
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; --i) {
            res[i] = stack.pop();
        }
        return res;
    }
}
