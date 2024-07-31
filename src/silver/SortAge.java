package silver;
import java.util.Scanner;

import java.util.*;

public class SortAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N개 갯수 입력 받기
        List<Person> members = new ArrayList<>(); // ArrayList 생성

        // 회원 정보 입력 받기
        for (int i = 0; i < N; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            members.add(new Person(age, name, i));
        }

        // 회원 정보 정렬: 나이순으로, 나이가 같으면 가입 순서대로
        Collections.sort(members, (p1, p2) -> {
            if (p1.age != p2.age) {
                return p1.age - p2.age; // 나이 순으로 정렬
            } else {
                return p1.index - p2.index; // 가입 순서대로 정렬
            }
        });

        // 정렬된 회원 정보 출력
        for (Person member : members) {
            System.out.println(member);
        }
    }

    // 회원 정보를 저장할 Person 클래스
    private static class Person {
        int age;
        String name;
        int index; // 가입 순서를 저장하는 필드

        public Person(int age, String name, int index) {
            this.age = age;
            this.name = name;
            this.index = index;
        }
    }
}
