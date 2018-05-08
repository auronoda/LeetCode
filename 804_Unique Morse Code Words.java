class Solution {
    String[] dir = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        StringBuilder sb;
        
        for (String word:words) {
            sb = new StringBuilder();
            for (int i = 0; i < word.length(); ++i) {
                sb.append(dir[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
