import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(10,2));
    }

    public static int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int a=0;
        for (int h = 1; h <= Math.sqrt(total); h++) {
            if (total % h == 0) {
                int w = total / h;
                if ((w - 2) * (h - 2) == yellow) {
                    return new int[] { w, h };
                }
            }
        }

        return new int[0];
    }
}