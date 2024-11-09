package gold;

import java.util.Scanner;

public class BJ9663 {
    private static int count = 0; //게임 경우의 수
    private static int[] board; //퀸을 놓는 배열(판) = 게임판

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //판 크기
        board = new int[n];
        backTracking(0, n);
        System.out.println(count);
    }

    // N-Queen 문제 해결을 위한 백트래킹 메소드
    private static void backTracking(int row, int n) {
        if (row == n) { // 모든 행에 퀸을 놓은 경우
            count++; // 경우의수 증가
            return;
        }

        for (int col = 0; col < n; col++) {
            if (checkQueen(row, col)) { // 현재 위치가 안전한지 확인
                board[row] = col; // 퀸을 현재 위치에 놓음
                backTracking(row + 1, n); // 다음 행으로 이동
            }
        }
    }

    // 현재 위치에 퀸을 놓을 수 있는지 검사하는 메소드
    private static boolean checkQueen(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) { // 같은 열에 있는 경우 | 대각선에 있는 경우
                return false; // 공격 가능 위치이므로 false 반환
            }
        }
        return true; // 안전한 위치이므로 true 반환
    }
}
