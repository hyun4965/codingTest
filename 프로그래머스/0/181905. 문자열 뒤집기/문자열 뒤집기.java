class Solution {
    public String solution(String my_string, int s, int e) {
        String front = my_string.substring(0, s);
        String mid = my_string.substring(s, e + 1);
        String reversedMid = new StringBuilder(mid).reverse().toString();
        String back = my_string.substring(e + 1);
        
        return front + reversedMid + back;
    }
}
