class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        for(int num : num_list){
            if(num % 2 == 0 ){
                String s = String.valueOf(num);
                sb1.append(s.charAt(0));
            }else{
                String s = String.valueOf(num);
                sb2.append(s.charAt(0));
            }
        }
        
        int num1 = Integer.parseInt(sb1.toString());
        int num2 = Integer.parseInt(sb2.toString());
        answer = num1 + num2;
        
        return answer;
    }
}