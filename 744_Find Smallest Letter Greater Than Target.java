class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length - 1;
        int mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (letters[mid] > target) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return letters[start] > target? letters[start]: letters[0];
    }
}
