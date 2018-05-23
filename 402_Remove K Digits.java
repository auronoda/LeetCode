class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); ++i) {
            while (!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.length() == 0? "0": sb.reverse().toString();
    }
}
