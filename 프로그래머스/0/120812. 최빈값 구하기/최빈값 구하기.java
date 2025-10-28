import java.util.*;

class Solution {
    public int solution(int[] array) {
        //1번째 CountSort 풀이
//         int answer = 0;
//         Arrays.sort(array);
//         int max = array[array.length-1];
//         int[] countSort = new int[max+1];
        
//         for(int i=0; i<array.length; i++){
//             int num = array[i];
//             countSort[num]++;
//         }
//         int maxCount = countSort[0];
        
//         for(int i=1; i<countSort.length; i++){
//             if(maxCount < countSort[i]){
//                 maxCount = countSort[i];
//                 answer = i;
//             }else if(maxCount == countSort[i]){
//                 answer = -1;
//             }
//         }
        
//         return answer;
        
        //2번째 풀이 : Map을 사용함
        Map<Integer, Integer> map = new HashMap<>();
        int max =0;
        int answer =0;
        
        for(int number : array){
            int count = map.getOrDefault(number,0)+1;
            if(count > max){
                max = count;
                answer = number;
            }else if(count == max){
                answer = -1;
            }
            map.put(number,count);
        }
        return answer;
    }
}