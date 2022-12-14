class Solution {
    static Set<Character> vowels = new HashSet<>();
    
    static {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }
    
    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        
        int l = 0;
        int h = s.length() - 1;
        int count = 0;

        while (l < h) {
            if (vowels.contains(s.charAt(l)))
                count ++;
            if (vowels.contains(s.charAt(h)))
                count --;
     
            l ++;
            h --;
        }
        
        return count == 0;
    }
}