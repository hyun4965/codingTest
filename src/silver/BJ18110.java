package silver;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BJ18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //앞뒤로 제거해야하는 15%씩 계산.
        int delete= (int) Math.round(n * 0.15);

        //리스트 생성 후 입력
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        //정렬. list이므로 Arrays 말고 Collections.
        Collections.sort(list);

        //더하기.
        int sum = 0;
        for (int i = delete; i < n - delete; i++) {
            sum += list.get(i);
        }
        //최종값 계산.
        double avg = (double) sum / (n - 2 * delete);
        System.out.println(Math.round(avg));
    }
}