class ValidWordAbbr {
    Set<String> abbrs;
    Set<String> dulAbbrs;
    Set<String> words;

    public ValidWordAbbr(String[] dictionary) {
        abbrs = new HashSet<>();
        dulAbbrs = new HashSet<>();
        words = new HashSet<>();
        for (String word: dictionary) {
            if (!words.add(word)) {
                continue;
            }
            if (!abbrs.add(abbr(word))) {
                dulAbbrs.add(abbr(word));
            }            
        }
    }
    
    public boolean isUnique(String word) {
        if (!words.contains(word)) {
            return !abbrs.contains(abbr(word));
        }
        return !dulAbbrs.contains(abbr(word));
    }
    
    private String abbr(String s) {
        if (s.length() <= 2) {
            return s;
        }
        return "" + s.charAt(0) + (s.length() - 2) + s.charAt(s.length() -1);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
