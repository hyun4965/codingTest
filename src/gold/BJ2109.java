package gold;
import java.util.*;

public class BJ2109 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 대학 강연 요청 개수

        List<int[]> lectures = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int p = sc.nextInt(); // 강연료
            int d = sc.nextInt(); // 마감일
            lectures.add(new int[]{p, d});
        }

        // 강연료 기준 내림차순 정렬 (같다면 마감일 기준 내림차순)
        lectures.sort((a, b) -> b[0] - a[0]);

        int maxDay = 0;
        for (int[] lecture : lectures) {
            maxDay = Math.max(maxDay, lecture[1]);
        }

        boolean[] booked = new boolean[maxDay + 1];
        int totalMoney = 0;

        for (int[] lecture : lectures) {
            int pay = lecture[0];
            int day = lecture[1];

            for (int d = day; d > 0; d--) { // 가능한 가장 늦은 날짜에 배정
                if (!booked[d]) {
                    booked[d] = true;
                    totalMoney += pay;
                    break;
                }
            }
        }

        System.out.println(totalMoney);
    }
}