class Solution {
    public int solution(String myString, String pat) {
        char[] chars = myString.toLowerCase().toCharArray();
        String c = String.valueOf(chars);
        String lowerPat = pat.toLowerCase();
        if (c.indexOf(lowerPat) >= 0) {
            return 1;
        } else {
            return 0;
        }
    }
}