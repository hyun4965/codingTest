class Solution {
    public int solution(int price) {
        if (price >= 500_000) {
            return price * 80 / 100;
        } else if (price >= 300_000) {
            return price * 90 / 100;
        } else if (price >= 100_000) {
            return price * 95 / 100;
        } else {
            return price;
        }
    }
}
