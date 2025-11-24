import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int L, C;
    static String[] arr;
    static String[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();

        arr = sc.nextLine().split(" ");

        Arrays.sort(arr);

        result = new String[L];

        backtrack(0, 0);

        System.out.println(sb);
    }

    static void backtrack(int start, int depth) {
        if (depth == L) {
            if (isValid()) {
                for (String s : result) {
                    sb.append(s);
                }
                sb.append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            result[depth] = arr[i];
            backtrack(i + 1, depth + 1);
        }
    }

    static boolean isValid() {
        int vowelCnt = 0; 
        int consCnt = 0; 
        String vowels = "aeiou";

        for (String s : result) {
            if (vowels.contains(s)) {
                vowelCnt++;
            } else {
                consCnt++;
            }
        }
        if(vowelCnt >= 1 && consCnt >= 2){
            return true;
        }else{
            return false;
        }
    }
}
