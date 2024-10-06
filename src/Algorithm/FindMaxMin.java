package Algorithm;

public class FindMaxMin {

    // 배열 A의 i부터 j까지에서 최솟값과 최댓값을 구하는 메서드
    public static void findMaxMin(int[] A, int i, int j, int[] result) {
        int min, max;

        // 배열 범위가 하나의 원소일 때
        if (i == j) {
            result[0] = A[i]; // min
            result[1] = A[i]; // max
        }
        // 배열에 두 개의 원소만 있을 때
        else if (i == j - 1) {
            if (A[i] < A[j]) {
                result[0] = A[i]; // min
                result[1] = A[j]; // max
            } else {
                result[0] = A[j]; // min
                result[1] = A[i]; // max
            }
        }
        // 배열에 두 개 이상의 원소가 있을 때
        else {
            int mid = (i + j) / 2;
            int[] result1 = new int[2]; // 왼쪽 부분 배열의 min, max
            int[] result2 = new int[2]; // 오른쪽 부분 배열의 min, max

            findMaxMin(A, i, mid, result1);
            findMaxMin(A, mid + 1, j, result2);

            // 전체 배열의 최솟값과 최댓값 계산
            result[0] = Math.min(result1[0], result2[0]); // min
            result[1] = Math.max(result1[1], result2[1]); // max
        }
    }

    public static void main(String[] args) {
        int[] A = {3, 5, 1, 8, 4, 7, 9, 2};
        int[] result = new int[2]; // result[0]: min, result[1]: max

        // A[0..n-1]의 최댓값과 최솟값 찾기
        findMaxMin(A, 0, A.length - 1, result);

        System.out.println("최솟값: " + result[0]);
        System.out.println("최댓값: " + result[1]);
    }
}
