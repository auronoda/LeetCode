class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] a2 = a.split("\\+"), b2 = b.split("\\+");
        int x1 = Integer.valueOf(a2[0]), x2 = Integer.valueOf(b2[0]);
        int y1 = Integer.valueOf(a2[1].substring(0, a2[1].length() - 1)), y2 = Integer.valueOf(b2[1].substring(0, b2[1].length() - 1));
        return "" + (x1 * x2 - y1 * y2) + '+' + (x1 * y2 + x2 * y1) + 'i';
    }
}
