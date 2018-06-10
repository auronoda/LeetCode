class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] counts = new int[26];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); ++i) {
            counts[S.charAt(i) - 'a']++;
        }
        
        int l = 0;
        int[] tmp = new int[26];
        int count = 0;
        
        for (int i = 0; i < S.length(); ++i) {
            l++;
            tmp[S.charAt(i) - 'a']++;
            
            if (tmp[S.charAt(i) - 'a'] == 1) {
                count++;
            }
            if (tmp[S.charAt(i) - 'a'] == counts[S.charAt(i) - 'a']) {
                count--;
            }
            
            if (count == 0) {
                res.add(l);
                l = 0; 
                tmp = new int[26];
            }
        }
        
        return res;
    }
}
