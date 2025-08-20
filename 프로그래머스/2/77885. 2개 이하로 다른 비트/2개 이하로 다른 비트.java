class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];

            if (x % 2 == 0) {
                answer[i] = x + 1;
            } else {
                String binaryString = Long.toBinaryString(x);
                int lastZeroIndex = binaryString.lastIndexOf('0');
                
                if (lastZeroIndex == -1) {
                    answer[i] = x + (long)Math.pow(2, binaryString.length()) - (long)Math.pow(2, binaryString.length() - 1);
                } else {

                    
                    long temp = x;
                    long lsb = 1; 
                    
                    while ((temp & 1) == 1) {
                        temp >>= 1;
                        lsb <<= 1;
                    }
                    
                    lsb >>= 1;
                    answer[i] = x + lsb;
                }
            }
        }
        
        return answer;
    }
}