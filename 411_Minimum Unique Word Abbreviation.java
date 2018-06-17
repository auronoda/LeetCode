class Solution {
    int l = 0;
    int res;
    int min;
    public String minAbbreviation(String target, String[] dictionary) {
        List<Integer> dic = new ArrayList<>();
        int cand = 0;
        l = target.length();
        for (String cur: dictionary) {
            if (cur.length() != l) {
                continue;
            }
            int tmp = 0; 
            for (int i = 0; i < l; ++i) {
                if (cur.charAt(i) != target.charAt(i)) {
                    tmp |= (1 << i);
                }
            }
            dic.add(tmp);
            cand |= tmp;
        }
        res = cand;
        min = getLength(res);
        
        dfs(0, 0, dic, cand);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < l; ++i) {
            if ((res & (1 << i)) != 0) {
                sb.append(target.charAt(i));
            }
            else {
                int j = i; 
                while (j + 1 < l && (res & (1 << (j + 1))) == 0) {
                    j++;
                }
                sb.append(j - i + 1);
                i = j;
            }            
        }
        System.out.print(sb.toString());
        return sb.toString();
    }
    
    private void dfs(int next, int mask, List<Integer> dic, int cand) {
        if (getLength((mask)) >= min) {
            return;
        }
        boolean vaild = true;
        for (int cur: dic) {
            if ((mask & cur) == 0) {
                vaild = false;
                break;
            }
        }
            
        if (vaild) {
            res = mask;
            min = getLength((mask));
            return;
        }
            
        for (int i = next; i <= l; ++i) {
            if ((cand & (1 << i)) != 0) {
                dfs(i + 1, (mask | (1 << i)), dic, cand);
            }
        }          
    }
    
    private int getLength(int n) {
        int res = l;
        int bn = 1<< l;
        for (int i = 3; i < bn; i <<= 1) {
            if ((n & i) == 0) {
                res--;
            }
        }
        return res;
    }
}
