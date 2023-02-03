class Solution {
    public String createStringFromList(ArrayList<String> list) {
        StringBuilder string = new StringBuilder();
        for(String s : list) string.append(s);
        return string.toString();
    }
    
    public String convert(String s, int numRows) {        
        if (numRows == 1) return s;
        
        ArrayList<String> list = new ArrayList();
        int strLen = s.length();
        int index;
                
        char[] ch = s.toCharArray();
        int maxRowIndex = numRows-1;
                
        for (int rowNum = 0; rowNum < numRows; rowNum++) {   
            index = rowNum;
            StringBuilder nstr = new StringBuilder(); 
            if (index >= ch.length)
                break;

            nstr.append(ch[index]);

            while(index < strLen) {
                index += (maxRowIndex - rowNum)*2;
            
                if (maxRowIndex == rowNum)
                    index += rowNum*2;
                
                if (index >= strLen)
                    break;
                
                nstr.append(ch[index]);

                if (rowNum != 0 && rowNum != numRows-1) {
                    index += rowNum*2;

                    if (index >= strLen)
                        break;
                    
                    nstr.append(ch[index]);
                }
            }

            list.add(nstr.toString());
        }

        return createStringFromList(list);
    }
}