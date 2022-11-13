class Solution {
    public static String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\s+");
        StringBuilder res = new StringBuilder();

        for (int i = words.length - 1; i >= 0 ; i --) {
            res.append(words[i]);
            res.append(i != 0 ? " " : "");
        }
        return res.toString();
    }
}