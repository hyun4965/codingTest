package silver;

import java.util.*;


public class CompanyMember {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = sc.next();
            String status = sc.next();

            if (status.equals("enter")) {
                map.put(name, status);
            } else if (status.equals("leave")) {
                map.remove(name);
            }
        }

        // Enter - Leave 해당사람 출력
        List<String> remainingPeople = new ArrayList<>(map.keySet());
        Collections.sort(remainingPeople, Collections.reverseOrder());

        for (String name : remainingPeople) {
            System.out.println(name);
        }
    }
}