package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Star1 {

    //2차원 배열 생성
    private static char[][] pattern;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        pattern = new char[N][N];
        stars(0, 0, N);
        
        //출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(pattern[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void stars(int x, int y, int size) {
        //size 가 1일때 단일 * 설정.
        if (size == 1) {
            pattern[x][y] = '*';
            return;
        }

        //3^n승일 때,
        int newSize = size / 3;
        //3X3 Grid 구역 탐색
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    for (int k = x + newSize; k < x + newSize + newSize; k++) {
                        for (int l = y + newSize; l < y + newSize + newSize; l++) {
                            //중앙구역 빈칸
                            pattern[k][l] = ' ';
                        }
                    }
                } else {
                    //재귀 호출
                    stars(x + i * newSize, y + j * newSize, newSize);
                }
            }
        }
    }
}
