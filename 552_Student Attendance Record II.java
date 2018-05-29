class Solution {
    public int checkRecord(int n) {
        
        int mod = 1000000007;
        int[][] ALCounts = new int[2][3];
        ALCounts[0][0] = 1;
        ALCounts[1][0] = 1;
        ALCounts[0][1] = 1;
        for (int i = 2; i <= n; ++i) {
            int[][] newALCounts = new int[2][3];
            newALCounts[0][0] = ((ALCounts[0][0] + ALCounts[0][1]) % mod + ALCounts[0][2]) % mod;
            newALCounts[1][0] = (((ALCounts[1][0] + ALCounts[1][1]) % mod + (ALCounts[1][2] + ALCounts[0][2]) % mod) % mod + (ALCounts[0][0] + ALCounts[0][1]) % mod) % mod;
            newALCounts[0][1] = ALCounts[0][0];
            newALCounts[1][1] = ALCounts[1][0];
            newALCounts[0][2] = ALCounts[0][1];
            newALCounts[1][2] = ALCounts[1][1];
            ALCounts = newALCounts;
        }
        int res = 0; 
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 3; ++j) {
                res = (res + ALCounts[i][j]) % mod;
            }
        }
        return res;
    }
}
