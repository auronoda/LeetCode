class Solution {
    public String similarRGB(String color) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (int i = 1; i <= 5; i += 2) {
            int q = Integer.parseInt(color.substring(i, i + 2), 16);
            q = q / 17 + (q % 17 > 8 ? 1 : 0);
            sb.append(String.format("%02x", 17 * q));
        }
        return sb.toString();
    }
}
