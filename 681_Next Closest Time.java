class Solution {
    public String nextClosestTime(String time) {
        boolean[] counts = new boolean[10];
        char[] chars = time.toCharArray();
        int min = 10;
        for (int i = 0; i < 5; ++i) {
            if (i == 2) {
                continue;
            }
            counts[chars[i] - '0'] = true;
            min = Math.min(min, chars[i] - '0');
        }
        for (int i = chars[4] - '0' + 1; i < 10; ++i) {
            if (counts[i]) {
                chars[4] = (char)(i + '0');
                return new String(chars);
            }           
        }
        
        for (int i = chars[3] - '0' + 1; i < 6; ++i) {
            if (counts[i]) {
                chars[3] = (char)(i + '0');
                chars[4] = (char)(min + '0');
                return new String(chars);
            }            
        }
        
        for (int i = chars[1] - '0' + 1; i <10 && i + 10 * (chars[0] - '0') < 24; ++i) {
            if (counts[i]) {
                chars[1] = (char)(i + '0');
                chars[3] = (char)(min + '0');
                chars[4] = (char)(min + '0');
                return new String(chars);
            }            
        }
        
        for (int i = chars[0] - '0' + 1; i < 2; ++i) {
            if (counts[i]) {
                chars[0] = (char)(i + '0');
                chars[1] = (char)(min + '0');
                chars[3] = (char)(min + '0');
                chars[4] = (char)(min + '0');
                return new String(chars);
            }            
        }
        
        chars[0] = (char)(min + '0');
        chars[1] = (char)(min + '0');
        chars[3] = (char)(min + '0');
        chars[4] = (char)(min + '0');
        return new String(chars);
    }
}
