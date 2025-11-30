package news;

import java.util.*;

public class BJ1764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //듣도 못한 사람
        int m = sc.nextInt(); //보도 못한 사람


        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(sc.next());
        }

        List<String> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String name = sc.next();
            if (set.contains(name)) {
                list.add(name);
            }
        }
        Collections.sort(list);

        System.out.println(list.size());
        for(String i : list){
            System.out.println(i);
        }

    }
}
