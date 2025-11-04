class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1; i<=number; i++){
            int num = isPrime(i);
            if(num > limit){
                answer+=power;
            }else{
                answer+=num;
            }
        }
        
        return answer;
    }
    public int isPrime(int num){
        int count = 0 ;
        
        for(int i=1; i * i <= num; i++){
            if (num % i == 0) {
                
                if (i * i == num) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
}