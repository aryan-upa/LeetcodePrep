class Solution {
    public String reverseWords(String s) {        
        return Arrays.stream(s.split(" "))
                .map((string) -> new StringBuffer(string).reverse().toString())
                .collect(Collectors.joining(" "))
                .toString();
    }
}
