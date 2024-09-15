package silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWord2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        boolean inValid = false;
        StringBuilder word = new StringBuilder(); // 뒤집을 단어를 저장

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '<') {
                sb.append(word.reverse());
                word.setLength(0); // 단어를 초기화
                inValid = true;
                sb.append(c); // '<' 추가
            } else if (c == '>') {
                // 태그 끝 시점: 태그 닫고 inTag 플래그를 false로 전환
                inValid = false;
                sb.append(c); // '>' 추가
            } else if (inValid) {
                // 태그 안에 있는 경우: 그대로 추가
                sb.append(c);
            } else {
                if (c == ' ') {
                    // 공백을 만나면, 현재까지의 단어를 뒤집고 결과에 추가
                    sb.append(word.reverse());
                    word.setLength(0); // 단어 초기화
                    sb.append(c); // 공백 추가
                } else {
                    word.append(c);
                }
            }
        }
        sb.append(word.reverse());

        System.out.println(sb.toString());
    }
}
