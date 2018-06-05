class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> invalid = new HashSet<>();
        for (String cur: deadends) {
            invalid.add(cur);
        }
        Queue<String> queue = new LinkedList<>();
        if (!invalid.add("0000")) {
            return -1;
        }
        queue.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; ++i) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return step;
                }
                StringBuilder sb = new StringBuilder(cur);
                for (int j = 0; j < 4; ++j) {
                    char c = cur.charAt(j);
                    sb.setCharAt(j, c == '9'? '0': (char)(c + 1));
                    if (invalid.add(sb.toString())) {
                        queue.add(sb.toString());
                    }
                    sb.setCharAt(j, c == '0'? '9': (char)(c - 1));
                    if (invalid.add(sb.toString())) {
                        queue.add(sb.toString());
                    }
                    sb.setCharAt(j, c);
                }
                
            }
            step++;
        }
        return -1;
    }
}
