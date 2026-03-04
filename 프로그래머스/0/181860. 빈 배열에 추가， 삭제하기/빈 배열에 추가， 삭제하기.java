import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        ArrayList<Integer> X = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (flag[i]) {
                int times = arr[i] * 2;
                for (int t = 0; t < times; t++) {
                    X.add(arr[i]);
                }
            } else {
                int removeCount = arr[i];
                for (int t = 0; t < removeCount; t++) {
                    X.remove(X.size() - 1);
                }
            }
        }

        int[] answer = new int[X.size()];
        for (int i = 0; i < X.size(); i++) {
            answer[i] = X.get(i);
        }
        return answer;
    }
}