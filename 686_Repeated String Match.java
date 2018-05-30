class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int res = 0;
        while (sb.length() < B.length() + A.length()) {
            sb.append(A);
            res++;
        }
        int index = sb.toString().indexOf(B);
        if (index == -1) {
            return -1;
        }
        return index + B.length() + A.length() <= sb.length()? res - 1: res;
    }
}
