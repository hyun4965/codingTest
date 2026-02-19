class Solution {
    public int solution(String binomial) {
        String[] str = binomial.split(" ");
        
        int a = Integer.parseInt(str[0]);
        String op = str[1];
        int b = Integer.parseInt(str[2]);
        
        if (op.equals("+")) {
            return a + b;
        } else if (op.equals("-")) {
            return a - b;
        } else { 
            return a * b;
        }
        
    }
}