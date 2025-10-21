class Solution {
    public int solution(int n) {
        String ternary = Integer.toString(n, 3);
        String reverse = new StringBuilder(ternary).reverse().toString();
        return Integer.parseInt(reverse, 3);
    }
}