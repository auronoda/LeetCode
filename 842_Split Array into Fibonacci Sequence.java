class Solution {
    public List<Integer> splitIntoFibonacci(String S) {

        for (int i = 1; i <= Math.min(10, S.length()); ++i) {
            if (i > 1 && S.charAt(0) == '0') {
                return new ArrayList<>();
            }
            long first = Long.parseLong(S.substring(0, i));
            if (first > Integer.MAX_VALUE) {
                break;
            }
            
            for (int j = 1; j <= 10 && i + j <= S.length(); ++j) {
                if (j > 1 && S.charAt(i) == '0') {
                    break;
                }
                long second = Long.parseLong(S.substring(i, i + j));
                if (second > Integer.MAX_VALUE) {
                    break;
                }
                
                List<Integer> res = new ArrayList<>();
                res.add((int)first);
                res.add((int)second);
                int next = i + j;
                while (next < S.length()) {
                    long sum = (long)res.get(res.size() - 1) + res.get(res.size() - 2);
                    if (sum > Integer.MAX_VALUE) {
                        break;
                    }
                    String s = String.valueOf(sum);
                    if (next + s.length() > S.length() || !S.substring(next, next + s.length()).equals(s)) {
                        break;
                    }
                    res.add((int)sum);
                    next += s.length();
                    
                }
                if (next == S.length() && res.size() >= 3) {
                    return res;
                }
            }
        }
        return new ArrayList<>();
    }
}
