package silver;

//import java.util.Scanner;
//
//public class NandM3 {
//    static int n,m;
////    static boolean[] isvisit;
//    static int[] seq;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//        seq = new int[n+1];
//        isvisit = new boolean[n+1];
//        def(0,1);
//    }
//    public static void def(int depth, int start) {
//        if (depth == m) {
//            for (int i = 0; i < m; i++) {
//                System.out.print(seq[i] + " ");
//            }
//            System.out.println();
//            return;
//        }
//
//        for (int i = 1; i <= n; i++) {
//            seq[depth] = i;
//            def(depth + 1, i);
//        }
//
//    }
//}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NandM3 {
    static int n, m;
    static int[] seq;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        seq = new int[m];
        def(0);
        System.out.print(sb.toString());
    }

    public static void def(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(seq[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            seq[depth] = i;
            def(depth + 1);
        }
    }
}
