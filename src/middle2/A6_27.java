package middle2;

public class A6_27 {
    // r 배열은 행렬들의 행과 열의 수를 저장
    // i부터 j까지의 행렬을 곱할 때 최소 곱셈 횟수를 반환하는 함수
    public static int matMult_DC(int[] r, int i, int j) {
        // 기저 조건: 행렬이 하나일 경우 곱셈이 필요하지 않음
        if (i == j) return 0;

        int minVal = Integer.MAX_VALUE; // 최소 곱셈 횟수를 무한대 값으로 초기화

        // i부터 j-1까지의 k를 기준으로 분할하여 최소 곱셈 횟수를 계산
        for (int k = i; k < j; k++) {
            int count = matMult_DC(r, i, k)
                    + matMult_DC(r, k + 1, j)
                    + r[i - 1] * r[k] * r[j]; // 분할한 두 부분의 곱셈 횟수와 현재 부분 곱셈 횟수 합산
            minVal = Math.min(minVal, count); // 최소 곱셈 횟수 갱신
        }

        return minVal; // 최종 최소 곱셈 횟수 반환
    }

    public static void main(String[] args) {
        int[] dimensions = {30, 35, 15, 5, 10, 20, 25}; // 예시 행렬의 차원
        int n = dimensions.length - 1; // 행렬의 개수

        int minMultiplications = matMult_DC(dimensions, 1, n);
        System.out.println("최소 곱셈 횟수: " + minMultiplications);
    }
}
