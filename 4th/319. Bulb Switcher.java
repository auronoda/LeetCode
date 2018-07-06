class Solution {
    public int bulbSwitch(int n) {
        int i = 1;
        int res = 0;
        while (i * i <= n) {
            res++;
            i++;
        }
        return res;
    }
}
