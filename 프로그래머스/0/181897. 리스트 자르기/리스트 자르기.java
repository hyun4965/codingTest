import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        List<Integer> list = new ArrayList<>();
        
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        
        int start = 0;
        int end = num_list.length - 1;
        int step = 1;
        
        if (n == 1) {
            start = 0;
            end = b;
        } else if (n == 2) {
            start = a;
            end = num_list.length - 1;
        } else if (n == 3) {
            start = a;
            end = b;
        } else if (n == 4) {
            start = a;
            end = b;
            step = c;
        }
        
        for (int i = start; i <= end; i += step) {
            list.add(num_list[i]);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}