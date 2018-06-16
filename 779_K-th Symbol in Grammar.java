class Solution {
    public int kthGrammar(int N, int K) {
        boolean fliper = false;
        while (K > 1) {
            int tmp = 1; 
            while (tmp * 2 < K) {
                tmp *= 2;
            }
            K -= tmp;
            fliper = !fliper;
        }
        return fliper? 1: 0;
    }
}
