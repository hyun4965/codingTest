package silver;

import java.util.Scanner;
import java.util.Arrays;

public class BJ10825 {

    static class Student implements Comparable<Student> {
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student other) {
            if (this.korean != other.korean) {
                return other.korean - this.korean; // 국어 (내림차순)
            }
            if (this.english != other.english) {
                return this.english - other.english; // 영어 (오름차순)
            }
            if (this.math != other.math) {
                return other.math - this.math; // 수학 (내림차순)
            }
            return this.name.compareTo(other.name); // 이름 (오름차순)
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int korean = sc.nextInt();
            int english = sc.nextInt();
            int math = sc.nextInt();

            students[i] = new Student(name, korean, english, math);
        }

        Arrays.sort(students);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(students[i].name).append('\n');
        }
        System.out.print(sb);
    }
}