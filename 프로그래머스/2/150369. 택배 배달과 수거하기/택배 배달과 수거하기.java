class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int needDeliver = 0; 
        int needPickup  = 0; 

        for (int i = n - 1; i >= 0; i--) {
            needDeliver -= deliveries[i];
            needPickup  -= pickups[i];

            while (needDeliver < 0 || needPickup < 0) {
                needDeliver += cap;
                needPickup  += cap;
                answer += (long) (i + 1) * 2;
            }
        }
        return answer;
    }
}
