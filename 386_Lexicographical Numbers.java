class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int cur = 1;
        res.add(cur);
        while (res.size() < n) {
            if (cur * 10 <= n) {
                cur *= 10; 
            }
            else if (cur < n && cur % 10 != 9) {
                cur++;
            }
            else {
                cur /= 10;
                while (cur % 10 == 9) {
                    cur /= 10;
                }
                cur++;
            }
            res.add(cur);
        }
        return res;
    }
}
