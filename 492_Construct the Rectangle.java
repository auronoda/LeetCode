class Solution {
    public int[] constructRectangle(int area) {
        if (area == 0) {
            return new int[]{0,0};
        }
        int a = (int)Math.sqrt(area);
        while (area % a != 0) {
            a--;
        }
        return new int[]{area / a, a};
    }
}
