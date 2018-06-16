class Solution {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() <= 1) {
            return true;
        }
        boolean first = (word.charAt(0) <= 'Z' && word.charAt(0) >= 'A');
        boolean second = (word.charAt(1) <= 'Z' && word.charAt(1) >= 'A');
        if (!first && second) {
            return false;
        }
        for (int i = 2; i < word.length(); ++i) {
            boolean cur = word.charAt(i) <= 'Z' && word.charAt(i) >= 'A';
            if (cur ^ second) {
                return false;
            }
        }
        return true;
    }
}
