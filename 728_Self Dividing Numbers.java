class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int cur = left; cur <= right; ++cur) {
            int tmp = cur;
            while (tmp > 0) {
                int digit = tmp % 10;
                if (digit == 0 || cur % digit != 0) {
                    break;
                }
                tmp /= 10;
            }
            if (tmp == 0) {
                res.add(cur);
            }
        }
        return res;
    }
}
