class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] ac = a.split("\\+");
        String[] bc = b.split("\\+");
        int x1 = Integer.valueOf(ac[0]), x2 = Integer.valueOf(bc[0]);
        int y1 = Integer.valueOf(ac[1].substring(0, ac[1].length() - 1)), y2 = Integer.valueOf(bc[1].substring(0, bc[1].length() - 1));
        
        return "" + (x1 * x2 - y1 * y2) + '+' + (x1 * y2 + x2 * y1) + 'i';
    }
}
