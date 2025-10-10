import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int colIndex = col - 1;

        Arrays.sort(data, (a, b) -> {
            if (a[colIndex] != b[colIndex]) {
                return Integer.compare(a[colIndex], b[colIndex]);
            } else {
                return Integer.compare(b[0], a[0]);
            }
        });

        int answer = 0;

        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int current_S = 0;
            for (int value : data[i]) {
                current_S += value % (i + 1);
            }
            answer ^= current_S;
        }

        return answer;
    }
}