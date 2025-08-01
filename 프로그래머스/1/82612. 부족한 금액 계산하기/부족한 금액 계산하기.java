class Solution {
    public long solution(int price, int money, int count) {
        long totalCost = (long) price * count * (count + 1) / 2;
        
        return totalCost > money ? totalCost - money : 0;
    }
}
