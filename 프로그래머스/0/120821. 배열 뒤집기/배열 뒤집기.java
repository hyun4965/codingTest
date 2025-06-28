import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] num_list) {
        int[] arr = new int[num_list.length];
        Deque<Integer> que = new ArrayDeque<>();

        for (int i = 0; i < num_list.length; i++) {
            que.add(num_list[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = que.pollLast(); 
        }

        return arr;
    }
}
