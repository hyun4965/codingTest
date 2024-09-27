package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BaseConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄에서 A와 B 읽기
        String[] firstLine = br.readLine().split(" ");
        int A = Integer.parseInt(firstLine[0]);
        int B = Integer.parseInt(firstLine[1]);

        // 두 번째 줄에서 m 읽기
        int m = Integer.parseInt(br.readLine());

        // 세 번째 줄에서 A진법 숫자들을 공백으로 구분하여 읽기
        String[] aDigitsStr = br.readLine().split(" ");
        int[] aDigits = new int[m];
        for (int i = 0; i < m; i++) {
            aDigits[i] = Integer.parseInt(aDigitsStr[i]);
        }

        // A진법에서 10진법으로 변환
        int decimalValue = 0;
        for (int i = 0; i < m; i++) {
            decimalValue = decimalValue * A + aDigits[i];
        }

        // 10진법에서 B진법으로 변환
        List<Integer> bDigits = new ArrayList<>();
        while (decimalValue > 0) {
            bDigits.add(decimalValue % B);
            decimalValue /= B;
        }

        // B진법으로 변환한 결과 출력 (높은 자릿수부터 출력)
        for (int i = bDigits.size() - 1; i >= 0; i--) {
            System.out.print(bDigits.get(i) + " ");
        }
    }
}
