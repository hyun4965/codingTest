import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] com = {
                {2, 5, 3},  // 첫 번째 행
                {4, 4, 1},  // 두 번째 행
                {1, 7, 3}   // 세 번째 행
        };
        System.out.println(solution(arr,com));

    }
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int m = 0; m < commands.length; m++) {
            int i = commands[m][0] - 1;
            int j = commands[m][1];
            int k = commands[m][2] - 1;

            int[] a = new int[j - i];
            for (int n = i; n < j; n++) {
                a[n - i] = array[n];
            }

            Arrays.sort(a);

            answer[m] = a[k];
        }
        return answer;
    }
}
