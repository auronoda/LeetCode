class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> strings = new Stack<>();
        Stack<Integer> counts = new Stack<>();
        int count = 0;
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            }
            else if (c == '[') {                
                strings.push(sb.toString());
                counts.push(count);
                count = 0;
                sb = new StringBuilder();
            }
            else if (c == ']') {
                int n = counts.pop();
                StringBuilder tmp = new StringBuilder(strings.pop());
                for (int i = 0; i < n; ++i) {
                    tmp.append(sb);
                }
                sb = tmp;
            }
            else {
                sb.append(c);
            }
        }
        while (!strings.isEmpty()) {
            sb.insert(0, strings.pop());
        }
        return sb.toString();
    }
}
