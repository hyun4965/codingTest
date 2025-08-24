import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));

        int answer = 0;
        int camera = Integer.MIN_VALUE;

        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];

            if (start > camera) {
                answer++;
                camera = end;
            }
        }

        return answer;
    }
}