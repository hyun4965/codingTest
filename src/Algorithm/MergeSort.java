package Algorithm;
public class MergeSort {
    // mergeSort 함수
    public static void mergeSort(int[] A, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(A, low, mid);        // 왼쪽 절반 정렬
            mergeSort(A, mid + 1, high);   // 오른쪽 절반 정렬
            merge(A, low, mid, high);      // 두 부분을 병합
        }
    }

    // merge 함수
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

    // 테스트를 위한 main 함수
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(array, 0, array.length - 1);

        System.out.println("정렬된 배열:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
