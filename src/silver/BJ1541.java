package silver;

import java.io.*;

public class BJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        // '-'를 기준으로 분리
        String[] minusSplit = s.split("-");

        int result = 0;

        // 첫 번째 부분은 더하기로 처리
        String[] plusSplit = minusSplit[0].split("\\+");

        //덧셈으로 나눈 토큰들 더함
        for (String num : plusSplit) {
            result += Integer.parseInt(num);
        }

        // 이후 나오는 부분은 모두 더한 뒤 빼기 처리
        for (int i = 1; i < minusSplit.length; i++) {
            plusSplit = minusSplit[i].split("\\+");
            int tempSum = 0;
            for (String num : plusSplit) {
                tempSum += Integer.parseInt(num);
            }
            result -= tempSum;
        }
        System.out.println(result);
    }
}
