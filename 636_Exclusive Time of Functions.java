class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        int prev = 0;
        
        for (String log: logs) {
            String[] strs = log.split(":");
            int id = Integer.valueOf(strs[0]);
            int time = Integer.valueOf(strs[2]);
            
            if (stack.isEmpty()) {
                stack.push(id);
                prev = time;
            }
            if (strs[1].equals("end")) {
                res[id] += time - prev + 1;
                stack.pop();
                prev = time + 1;
            }
            else {
                res[stack.peek()] += time - prev;
                stack.push(id);
                prev = time;
            }
        }
        
        return res;
    }
}
