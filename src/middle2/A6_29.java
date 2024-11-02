package middle2;

//O(n^3)
public class A6_29 {
    public static void main(String[] args) {
        int[] r = {10, 20, 30, 40};  // 행렬 크기 배열 (예: M1=10x20, M2=20x30, M3=30x40)
        int n = r.length - 1;        // 행렬의 개수는 r 배열의 길이보다 1 작습니다.
        System.out.println("최소 곱셈 횟수: " + matrixChainOrder(r, n));
    }

    public static int matrixChainOrder(int[] r, int n) {
        int[][] m = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++) {
            m[i][i]=0;
        }

        for (int h = 1; h <= n - 1; h++) {
            for (int i = 1; i <= n - h; i++) {
                int j = i + h; //구하려는 index의 끝
                m[i][j] = Integer.MAX_VALUE;  // 최소값을 찾기 위해 무한대로 초기화

                // i부터 j까지의 최소 곱셈 횟수를 계산합니다.
                for (int k = i; k < j; k++) {
                    int cost = m[i][k] + m[k + 1][j] + r[i - 1] * r[k] * r[j];
                    m[i][j] = Math.min(m[i][j], cost);  // 최소 곱셈 횟수 갱신
                }
                /*
                    m[i][j] = Integer.MAX_VALUE;: 최소값을 찾기 위해 m[i][j]를 무한대로 초기화합니다.
                    for (int k = i; k < j; k++): k는 행렬 곱셈을 두 부분으로 나누는 경계를 나타냅니다.
                    int cost = m[i][k] + m[k + 1][j] + r[i - 1] * r[k] * r[j];: M_i에서 M_j까지 곱셈을 할 때의 총 비용을 계산합니다.
                    m[i][j] = Math.min(m[i][j], cost);: 최소값을 갱신하여 m[i][j]에 저장합니다.
                 */
            }
        }

        return m[1][n];
    }
}