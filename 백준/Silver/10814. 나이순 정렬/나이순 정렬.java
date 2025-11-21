import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Member {
        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Member> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            list.add(new Member(age, name));
        }

        Collections.sort(list, (m1, m2) -> m1.age - m2.age);

        StringBuilder sb = new StringBuilder();
        for (Member m : list) {
            sb.append(m).append('\n'); 
        }
        System.out.println(sb);
    }
}