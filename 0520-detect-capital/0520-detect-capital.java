class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.charAt(0) >= 65 && word.charAt(0) < 97) {
            if (word.toUpperCase().equals(word))
                return true;
            else if (word.substring(1).toLowerCase().equals(word.substring(1)))
                return true;
            else
                return false;
        } else {
            return word.toLowerCase().equals(word);
        }
    }
}