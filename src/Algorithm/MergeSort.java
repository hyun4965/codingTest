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

//public class MergeSort {
//
//    // mergeSort 함수
//    public static void mergeSort(int[] A, int low, int high) {
//        if (low < high) {
//            int mid = (low + high) / 2;
//            mergeSort(A, low, mid);        // 왼쪽 절반 정렬
//            mergeSort(A, mid + 1, high);   // 오른쪽 절반 정렬
//            merge(A, low, mid, high);      // 두 부분을 병합
//        }
//    }
//
//    // merge 함수
//    public static void merge(int[] A, int low, int mid, int high) {
//        int[] B = new int[high + 1]; // 임시 배열 B 생성
//        int h = low, i = low, j = mid + 1;
//
//        // 두 부분 배열을 병합
//        while (i <= mid && j <= high) {
//            if (A[i] <= A[j]) {
//                B[h] = A[i];
//                i++;
//            } else {
//                B[h] = A[j];
//                j++;
//            }
//            h++;
//        }
//
//        // 남은 원소 처리
//        if (i > mid) {
//            for (int k = j; k <= high; k++) {
//                B[h] = A[k];
//                h++;
//            }
//        } else {
//            for (int k = i; k <= mid; k++) {
//                B[h] = A[k];
//                h++;
//            }
//        }
//
//        // 병합된 결과를 배열 A에 복사
//        for (int k = low; k <= high; k++) {
//            A[k] = B[k];
//        }
//    }
//
//    // 중복 제거 함수
//    public static int[] removeDuplicates(int[] A) {
//        // 배열이 비어 있으면 그대로 반환
//        if (A.length == 0) return A;
//
//        // 중복을 제거한 결과를 담을 임시 배열
//        int[] result = new int[A.length];
//        int j = 0;
//
//        // 배열을 순회하며 중복 제거
//        for (int i = 0; i < A.length - 1; i++) {
//            if (A[i] != A[i + 1]) {
//                result[j++] = A[i];
//            }
//        }
//        result[j++] = A[A.length - 1]; // 마지막 원소 추가
//
//        // 중복을 제거한 배열 반환
//        return java.util.Arrays.copyOf(result, j);
//    }
//
//    // 테스트를 위한 main 함수
//    public static void main(String[] args) {
//        int[] array = {38, 27, 43, 3, 9, 82, 10, 9, 3, 27};
//
//        // 배열을 정렬
//        mergeSort(array, 0, array.length - 1);
//
//        // 중복을 제거한 배열
//        int[] uniqueArray = removeDuplicates(array);
//
//        // 결과 출력
//        System.out.println("중복 제거 후 배열:");
//        for (int num : uniqueArray) {
//            System.out.print(num + " ");
//        }
//    }
//}
