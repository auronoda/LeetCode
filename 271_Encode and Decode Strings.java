public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String cur: strs) {
            sb.append(cur.replace("#", "##")).append(" # ");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] strs = s.split(" # ", -1);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < strs.length - 1; ++i) {
            res.add(strs[i].replace("##", "#"));
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
