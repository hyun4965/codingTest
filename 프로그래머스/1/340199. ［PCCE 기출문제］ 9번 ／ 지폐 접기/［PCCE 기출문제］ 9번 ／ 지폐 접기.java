import java.util.Arrays; 

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        Arrays.sort(wallet);
        
        while (true) {
            
            int bill_small = Math.min(bill[0], bill[1]);
            int bill_large = Math.max(bill[0], bill[1]);

            if (bill_small <= wallet[0] && bill_large <= wallet[1]) {
                break; 
            }
            answer++;
            
            if (bill[0] > bill[1]) {
                bill[0] = bill[0] / 2; 
            } else {
                bill[1] = bill[1] / 2;
            }
        }
        
        return answer;
    }
}