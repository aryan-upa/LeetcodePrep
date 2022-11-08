class Solution {
    public int maximum69Number (int num) {
        String str = String.valueOf(num);
        
        if (str.indexOf("" + '6') < 0)
            return num;
        else {
            int pos = str.indexOf("" + 6);
            int res = Integer.valueOf(str.substring(0,pos) + '9' + str.substring(pos+1));
            return res;
        }
            
    }
}