class Solution {
    public String decodeAtIndex(String encodedString, int k) {
        Stack<Long> characterLengths = new Stack<>(); 

        characterLengths.push(0L);

        for (int i = 0; i < encodedString.length(); i ++) {
            char c = encodedString.charAt(i);
            long lastLen = characterLengths.peek();
            long length = Character.isDigit(c) ? lastLen * (c - '0') : lastLen + 1;

            characterLengths.push(length);
        }

        int len = characterLengths.size();

        while (!characterLengths.isEmpty()) {
            k %= characterLengths.peek();
            len -= 1;

            if (k == 0 && Character.isLetter(encodedString.charAt(len - 1)))
                return "" + encodedString.charAt(len - 1);

            characterLengths.pop();
        }

        return "";
    }
}