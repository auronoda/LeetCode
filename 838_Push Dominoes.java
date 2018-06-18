class Solution {
    public String pushDominoes(String dominoes) {
        Set<Integer> l = new HashSet<>();
        Set<Integer> r = new HashSet<>();
        char[] status = new char[dominoes.length()];
        for (int i = 0; i < dominoes.length(); ++i) {
            if (dominoes.charAt(i) == 'L') {
                l.add(i);
            }
            else if (dominoes.charAt(i) == 'R') {
                r.add(i);
            }
            status[i] = dominoes.charAt(i);
        }
        
        while (!l.isEmpty() || !r.isEmpty()) {
            Set<Integer> nl = new HashSet<>();
            Set<Integer> nr = new HashSet<>();
            Set<Integer> dul = new HashSet<>();
            for (int cur: l) {
                if (cur > 0 && status[cur - 1] == '.') {
                    nl.add(cur - 1);
                }
            }
            for (int cur: r) {
                if (cur  < dominoes.length() - 1 && status[cur + 1] == '.') {
                    nr.add(cur + 1);
                }
            }
            
            for (int cur: nl) {
                if (nr.contains(cur)) {
                    dul.add(cur);
                }
                else {
                    status[cur] = 'L';
                }
            }
            for (int cur: dul) {
                nl.remove(cur);
                nr.remove(cur);
            }
            for (int cur: nr) {
                status[cur] = 'R';
            }
            l = nl; 
            r = nr;
        }
        return new String(status);
    }
}
