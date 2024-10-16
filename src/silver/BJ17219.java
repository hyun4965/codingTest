package silver;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BJ17219 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //사이트수
        int M = sc.nextInt(); //비밀번호 사이트 주소
        sc.nextLine();
        //사이트주소 + 비밀번호 저장 mapping
        Map<String,String> map = new HashMap<>();

        //입력
        for (int i = 0; i < N; i++) {
            String[] input = sc.nextLine().split(" ");
            map.put(input[0], input[1]);
        }
        //출력
        for (int i = 0; i < M; i++) {
            String site = sc.nextLine();
            System.out.println(map.get(site));
        }
    }
}
