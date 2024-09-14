package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeSort1 {

    private static int[] array;
    private static int[] tempArray;
    private static int K;
    private static int saveCount = 0;
    private static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        array = new int[N];
        tempArray = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);

        System.out.println(result);
    }

    private static void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private static void merge(int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                tempArray[k++] = array[i++];
            } else {
                tempArray[k++] = array[j++];
            }
        }

        while (i <= mid) {
            tempArray[k++] = array[i++];
        }

        while (j <= right) {
            tempArray[k++] = array[j++];
        }

        for (i = left; i <= right; i++) {
            array[i] = tempArray[i];
            saveCount++;
            if (saveCount == K) {
                result = array[i];
            }
        }
    }
}
