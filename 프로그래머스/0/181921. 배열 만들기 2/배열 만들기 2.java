import java.util.*;
class Solution {
    // 1. Greed 하게 전체 찾기.
    // 2. 마지막 글자만 구분해보기
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        
        for(int i=l; i<=r; i++){
            String str = i+"";
            int count = 0;
            for(int j=0; j<str.length(); j++){
                if(str.charAt(j) == '0' || str.charAt(j)=='5'){
                    count++;
                }
            }
            if(count == str.length()){
                list.add(i);
            }
        }
        
        int[] answer = new int[list.size()];
        int[] emtpy = {-1};
        if(list.size()==0){
            return emtpy;
        }
        for(int i=0; i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}