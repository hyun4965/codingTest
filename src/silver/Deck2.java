package silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Deck2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deck = new ArrayDeque<Integer>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");

            switch (Integer.parseInt(command[0])) {
                case 1:
                    deck.addFirst(Integer.parseInt(command[1]));
                    break;

                case 2:
                    deck.addLast(Integer.parseInt(command[1]));
                    break;

                case 3:
                    if (deck.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deck.pollFirst() + "\n");  // 덱의 앞에서 값을 제거하고 출력
                    }
                    break;

                case 4:
                    if (deck.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deck.pollLast() + "\n");  // 덱의 뒤에서 값을 제거하고 출력
                    }
                    break;

                case 5:
                    bw.write(deck.size() + "\n");  // 덱의 크기를 출력
                    break;

                case 6:
                    if (deck.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;

                case 7:
                    if (deck.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deck.peekFirst() + "\n");  // 덱의 앞의 값을 출력
                    }
                    break;

                case 8:
                    if (deck.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        bw.write(deck.peekLast() + "\n");  // 덱의 뒤의 값을 출력
                    }
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}