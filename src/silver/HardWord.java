package silver;

import java.io.*;
import java.util.*;
/*
1.자주 나오는 단어일수록 앞에 배치한다.
2.해당 단어의 길이가 길수록 앞에 배치한다.
3.알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
 */
public class HardWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 단어 개수
        int M = Integer.parseInt(st.nextToken());  // 외울 단어의 최소 길이

        Map<String, Integer> wordMap = new HashMap<>();

        // 단어 입력받기 및 등장 횟수 기록
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {  // 길이가 M 이상인 단어만 고려
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }

        // 단어 정렬 (등장 빈도, 길이, 알파벳 순)
        List<String> wordList = new ArrayList<>(wordMap.keySet());
        Collections.sort(wordList, (w1, w2) -> {
            int freqCompare = wordMap.get(w2) - wordMap.get(w1);  // 빈도 내림차순
            if (freqCompare == 0) {
                int lengthCompare = w2.length() - w1.length();  // 길이 내림차순
                if (lengthCompare == 0) {
                    return w1.compareTo(w2);  // 알파벳 사전 순
                }
                return lengthCompare;
            }
            return freqCompare;
        });

        // 결과 출력
        for (String word : wordList) {
            bw.write(word + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
