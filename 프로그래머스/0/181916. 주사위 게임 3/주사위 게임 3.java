import java.util.Arrays;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        
        int[] dice = {a, b, c, d};
        Arrays.sort(dice);
        
        int n1 = dice[0];
        int n2 = dice[1];
        int n3 = dice[2];
        int n4 = dice[3];

        
        if (n1 == n4) {
            answer = 1111 * n1;
        } else if (n1 == n3) {
            int p = n1;
            int q = n4;
            answer = (int) Math.pow(10 * p + q, 2);
        } else if (n2 == n4) {
            int p = n2;
            int q = n1;
            answer = (int) Math.pow(10 * p + q, 2);
        } else if (n1 == n2 && n3 == n4) {
            int p = n1;
            int q = n3;
            answer = (p + q) * Math.abs(p - q);
        } else if (n1 == n2) {
            int q = n3;
            int r = n4;
            answer = q * r;
        } else if (n2 == n3) {
            int q = n1;
            int r = n4;
            answer = q * r;
        } else if (n3 == n4) {
            int q = n1;
            int r = n2;
            answer = q * r;
        } else {
            answer = n1; 
        }
        
        return answer;
    }
}