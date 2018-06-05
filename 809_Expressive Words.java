class Solution {
    private class Group {
        char c;
        int count;
        Group(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
    
    public int expressiveWords(String S, String[] words) {
        List<Group> groups = getGroups(S);
        int res = 0;
        for (String word: words) {
            List<Group> tmp = getGroups(word);
            boolean flag = true;
            if (groups.size() != tmp.size()) {
                continue;
            }
            for (int i = 0; i < groups.size(); ++i) {
                if (!extendable(groups.get(i), tmp.get(i))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res++;
            }
        }
        return res;
    }
    
    private List<Group> getGroups(String S) {
        List<Group> res = new ArrayList<>();
        if (S.length() == 0) {
            return res;
        }
        char ch = S.charAt(0);
        int count = 1;
        for (int i = 1; i <S.length(); ++i) {
            if (S.charAt(i) == ch) {
                count++;
            }
            else {
                res.add(new Group(ch, count));
                count = 1;
            }
            ch = S.charAt(i);
        }
        res.add(new Group(ch, count));
        return res;
    }
    
    private boolean extendable(Group a, Group b) {
        if (a.c != b.c) {
            return false;
        }
        if (a.count == b.count) {
            return true;
        }
        return a.count >= 3 && a.count > b.count;
    }
}
