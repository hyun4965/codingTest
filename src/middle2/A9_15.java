package middle2;

public class A9_15 {
    public static void permute(int[] A, int k, int N) {
        // 순열이 완성된 경우 출력
        if (k == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(A[i] + " ");
            }
            System.out.println();
            return;
        }

        // A[k]에 들어갈 값을 결정
        for (int i = 1; i <= N; i++) {
            if (promising(A, k, i)) {
                A[k] = i; // A[k]를 i로 설정
                permute(A, k + 1, N); // 다음 단계 재귀 호출
            }
        }
    }
    // A[k]에 값 i를 넣을 수 있는지 확인
    public static boolean promising(int[] A, int k, int i) {
        for (int j = 0; j < k; j++) {
            if (A[j] == i) {
                return false;
            }
        }
        return true;
    }

    // 메인 함수
    public static void main(String[] args) {
        int N = 3; // N개의 숫자로 순열 생성
        int[] A = new int[3]; // 순열을 저장할 배열
        permute(A, 0, 3); // 초기 호출
    }
}
