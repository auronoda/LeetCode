class Solution {
    public int compress(char[] chars) {
        int slow = 0, fast = 0;
        int count = 0;
        char c = chars[0];
        while (fast < chars.length) {
            if (chars[fast] == c) {
                count++;
            }
            else {
                chars[slow++] = c;
                if (count > 1) {
                    int tmp = 1; 
                    while (count >= tmp * 10) {
                        tmp *= 10;
                    }
                    while (tmp > 0) {
                        chars[slow++] = (char)('0' + count / tmp);
                        count %= tmp;
                        tmp /= 10;
                    }
                }
                c = chars[fast];
                count = 1;
            }
            fast++;
        }
        chars[slow++] = c;
        if (count > 1) {
            int tmp = 1; 
            while (count >= tmp * 10) {
                tmp *= 10;
            }
            while (tmp > 0) {
                chars[slow++] = (char)('0' + count / tmp);
                count %= tmp;
                tmp /= 10;
            }
        }
        return slow;
    }
}
