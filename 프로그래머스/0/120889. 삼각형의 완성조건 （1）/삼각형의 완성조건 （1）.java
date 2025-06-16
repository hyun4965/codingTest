import java.util.*;

class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        int count = sides[0] + sides[1];
        if(sides[2] >= count){
            return 2;
        }else{
            return 1;
        }
    }
}