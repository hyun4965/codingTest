import java.util.*;

class Solution {
    // data : 코드번호 , 제조일, 최대수량, 현재수량
    //ext : 기준점
    //기준값 정수 : val_ext
    //정렬할 기준 
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extIdx = getIndex(ext);
        int sortIdx = getIndex(sort_by);
        
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<data.length; i++){
            if(data[i][extIdx] < val_ext){
                list.add(data[i]);
            }
        }
        Collections.sort(list, (a, b) -> a[sortIdx] - b[sortIdx]);

        int[][] answer = new int[list.size()][];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    private int getIndex(String s){
        if (s.equals("code")) return 0;
        if (s.equals("date")) return 1;
        if (s.equals("maximum")) return 2;
        return 3; 
    }
}