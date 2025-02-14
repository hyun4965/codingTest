package gold;

import java.util.*;

public class BJ1202 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //보석의 갯수
        int K = sc.nextInt(); //가방의 갯수

        List<int[]> jewels = new ArrayList<>();
        List<Integer> bags = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int Mi = sc.nextInt(); // 보석의 무게
            int Vi = sc.nextInt(); // 보석의 가격
            jewels.add(new int[]{Mi, Vi});
        }

        for (int i = 0; i < K; i++) {
            bags.add(sc.nextInt()); // 가방에 담을 수 있는 최대 무게
        }
        System.out.println(getMaxJewelryValue(N, K, jewels, bags));
    }
    public static long getMaxJewelryValue(int N, int K, List<int[]> jewels, List<Integer> bags) {

        // 보석을 무게 기준으로 정렬
        jewels.sort(Comparator.comparingInt(a -> a[0]));

        // 가방을 무게 기준으로 정렬
        Collections.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long maxPrice = 0;
        int jewelIndex = 0;

        for (int bag : bags) {
            while (jewelIndex < N && jewels.get(jewelIndex)[0] <= bag) {
                pq.add(jewels.get(jewelIndex)[1]);
                jewelIndex++;
            }

            if (!pq.isEmpty()) {
                maxPrice += pq.poll();
            }
        }

        return maxPrice;
    }
}
