class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer =strings;
        
        for(int i=0; i<strings.length;i++){
            for(int j=i+1; j<strings.length;j++){
                char c1 = strings[i].charAt(n);
                char c2 = strings[j].charAt(n);
                
                if(c2 < c1 ){
                    String swap = strings[i];
                    strings[i] = strings[j];
                    strings[j] = swap;
                }else if(c2 == c1){
                    if(strings[j].compareTo(strings[i])<0){
                        String swap = strings[i];
                        strings[i] = strings[j];
                        strings[j] = swap;
                    }
                }
                
            }
        
        }
        
        return answer;
    }
}