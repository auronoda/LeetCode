class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int res = 0; 
        int prev = -2;
        for (int i = 0; i < flowerbed.length; ++i) {
            if (flowerbed[i] == 1) {
                res += (i - prev - 1 - 1) / 2;
                if (res >= n) {
                    return true;
                }
                prev = i;
            }
        }
        res += (flowerbed.length + 1 - prev - 2) / 2;
        return res >= n;
    }
}
