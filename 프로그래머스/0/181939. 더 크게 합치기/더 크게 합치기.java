class Solution {
    public int solution(int a, int b) {
        String ab = String.valueOf(a) + b;
        String ba = String.valueOf(b) + a;

        return ab.compareTo(ba) >= 0 ? Integer.parseInt(ab) : Integer.parseInt(ba);
    }
}