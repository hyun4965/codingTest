package Algorithm;

public class MaxDifferencePartition {

    // MergeSort 함수
    public static void mergeSort(int[] A, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(A, low, mid);        // 왼쪽 절반 정렬
            mergeSort(A, mid + 1, high);   // 오른쪽 절반 정렬
            merge(A, low, mid, high);      // 두 부분을 병합
        }
    }

    // Merge 함수
    public static void merge(int[] A, int low, int mid, int high) {
        int[] B = new int[high + 1]; // 임시 배열 B 생성
        int h = low, i = low, j = mid + 1;

        // 두 부분 배열을 병합
        while (i <= mid && j <= high) {
            if (A[i] <= A[j]) {
                B[h] = A[i];
                i++;
            } else {
                B[h] = A[j];
                j++;
            }
            h++;
        }

        // 남은 원소 처리
        if (i > mid) {
            for (int k = j; k <= high; k++) {
                B[h] = A[k];
                h++;
            }
        } else {
            for (int k = i; k <= mid; k++) {
                B[h] = A[k];
                h++;
            }
        }

        // 병합된 결과를 배열 A에 복사
        for (int k = low; k <= high; k++) {
            A[k] = B[k];
        }
    }

    // 위 Merge Sort는 3번과 마찬가지로 사용하였다.
    // 두 목록으로 나누었을 때 합의 차이를 계산하는 함수
    public static int MaxValue(int[] arr) {
        // 배열을 MergeSort로 정렬
        mergeSort(arr, 0, arr.length - 1);

        int sum1 = 0, sum2 = 0;
        int n = arr.length;

        // 큰 수는 sum1에 넣고 작은 수는 sum2에 넣음
        for (int i = 0; i < n / 2; i++) {
            sum1 += arr[n - 1 - i];  // 큰 수는 sum1에 추가
            sum2 += arr[i];          // 작은 수는 sum2에 추가
        }

        // 두 합의 차이를 반환 abs를 통해 양수로 출력.
        return Math.abs(sum1 - sum2);
    }

    // 테스트를 위한 main 함수
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        int result = MaxValue(array);
        System.out.println("최대 합 차이: " + result);
    }
}
