package silver;

import java.util.Arrays;
import java.util.Scanner;

public class BJ1049 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 끊어진 기타줄 개수
        int M = sc.nextInt(); // 기타줄 브랜드
        int Min = Integer.MAX_VALUE;

        int[] unit = new int[M];
        int[] pack = new int[M];

        for(int i=0; i<M; i++){
            pack[i] = sc.nextInt();
            unit[i] = sc.nextInt();
        }
        Arrays.sort(unit);
        Arrays.sort(pack);

        Min = Math.min(((N/6)+1)*pack[0], N*unit[0]);
        Min = Math.min(Min, ((N/6))*pack[0] + (N%6)*unit[0]);
        System.out.println(Min);
    }
}
