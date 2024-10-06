package Algorithm;

public class QuickSort {

    // 배열을 퀵 정렬하는 함수
    public static void quickSort(int[] A, int low, int high) {
        if (low < high) {
            int s = partition(A, low, high); // 피봇을 기준으로 분할
            quickSort(A, low, s - 1);        // 왼쪽 부분 정렬
            quickSort(A, s + 1, high);       // 오른쪽 부분 정렬
        }
    }

    // 배열을 분할하는 함수
    public static int partition(int[] A, int low, int high) {
        int i = low + 1;
        int j = high;

        // 피봇을 기준으로 배열을 분할
        while (i <= j) {
            while (i <= high && A[i] <= A[low]) {
                i++;
            }
            while (j >= low && A[j] > A[low]) {
                j--;
            }
            if (i < j) {
                swap(A, i, j);
            }
        }
        // 피봇과 A[j]를 교환하여 피봇의 최종 위치 결정
        swap(A, low, j);
        return j; // 피봇의 위치 반환
    }

    // 배열의 두 요소를 교환하는 함수
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // 테스트를 위한 main 함수
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        quickSort(array, 0, array.length - 1);

        System.out.println("정렬된 배열:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
