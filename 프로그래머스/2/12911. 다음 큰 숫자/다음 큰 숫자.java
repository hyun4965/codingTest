class Solution {
    public int solution(int n) {
        String str = Integer.toBinaryString(n).replace("0", "");
        int result = 0;

        while (true) {
            String s = Integer.toBinaryString(++n).replace("0", "");

            if (str.length() == s.length()) return n;
        }
    }
}