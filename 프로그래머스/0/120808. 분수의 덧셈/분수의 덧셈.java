class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int bottom = denom1 * denom2;
        int top = numer1 * denom2 + numer2 * denom1;
        int m = gcd(bottom, top);
        
        answer[0] = top / m;
        answer[1] = bottom / m;
        
        return answer;
    }
    int gcd(int num1,int num2){
        if(num1 % num2 ==0){
            return num2;
        }
        return gcd(num2, num1%num2);
    }
}