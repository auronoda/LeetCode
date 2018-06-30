class Solution {
    public String getPermutation(int n, int k) {
        int tmp = 1;
        boolean[] used = new boolean[n + 1];
        for (int i = 1; i < n; ++i) {
            tmp *= i;
        }
        StringBuilder sb = new StringBuilder();
        k--;
        for (int i = 1; i < n; ++i) {
            int j = k / tmp + 1;
            int count = 0;
            for (int l = 1; l <= n; ++l) {
                if (!used[l]) {
                    count++;
                    if (count == j) {
                        used[l] = true;
                        sb.append(l);
                        break;
                    }
                }
            }
            k %= tmp;
            tmp /= (n - i);
            
        }
        for (int l = 1; l <= n; ++l) {
            if (!used[l]) {
                sb.append(l);
                break;
            }
        }
        return sb.toString();
    }
}
