class Solution {
    private class pair {
        char ch;
        int count;
        public pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
    
    public String reorganizeString(String S) {
        int[] counts = new int[26];
        for (int i = 0; i < S.length(); ++i) {
            counts[S.charAt(i) - 'a']++;
        }
        PriorityQueue<pair> heap = new PriorityQueue<pair>(new Comparator<pair>(){
            public int compare(pair a, pair b) {
                return b.count - a.count;
            }
        });
        
        for (int i = 0; i < 26; ++i) {
            if (counts[i] > 0) {
                heap.add(new pair((char)('a' + i), counts[i]));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            pair tmp = heap.poll();
            if (sb.length() == 0 || tmp.ch != sb.charAt(sb.length() - 1)) {
                sb.append(tmp.ch);
                if (tmp.count > 1) {
                    tmp.count--;
                    heap.add(tmp);
                }
            }
            else {
                if (heap.isEmpty()) {
                    return "";
                }
                pair tmp2 = heap.poll();
                sb.append(tmp2.ch);
                if (tmp2.count > 1) {
                    tmp2.count--;
                    heap.add(tmp2);
                }
                heap.add(tmp);
            }
        }
        return sb.toString();
    }
}
