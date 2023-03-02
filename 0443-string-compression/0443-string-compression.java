class Solution {
    public int compress(char[] chars) {
        if (chars.length == 1)
            return 1;
        
        int s = 0;
        int e = 0;
        
        StringBuilder res = new StringBuilder();
        char prev = chars[0];
        
        while (e < chars.length) {
            if (chars[e] == prev) {
                e += 1;
                continue;
            }
            
            res.append(prev);
            if (e - s > 1) res.append(e - s);
            
            s = e;
            prev = chars[e];
        }

        res.append(prev);
        if (e - s > 1) res.append(e - s);

        String result = res.toString();
        
        for (int i = 0; i < result.length(); i ++)
            chars[i] = result.charAt(i);
        
        return result.length();
    }
}