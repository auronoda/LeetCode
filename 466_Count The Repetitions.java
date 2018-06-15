class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) {
            return 0;
        }
        int[] indexs = new int[s2.length() + 1];
        int[] counts = new int[s2.length() + 1];
        int index = 0, count = 0;
        for (int i = 0; i < n1; ++i) {
            for (char c: s1.toCharArray()) {
                if (c == s2.charAt(index)) {
                    index++;
                }
                if (index == s2.length()) {
                    index = 0; 
                    count++;
                }
            }
            
            indexs[i] = index;
            counts[i] = count;
            for (int k = 0; k < i; ++k) {
                if (indexs[k] == indexs[i]) {
                    int res = counts[k];
                    res += (counts[i] - counts[k]) * ((n1 - k - 1) / (i - k));
                    res += counts[k + ((n1 - i - 1) % (i - k))] - counts[k];
                    return res / n2;
                }
            }
            
        }
        
        return counts[n1 - 1] / n2;
    }
}
