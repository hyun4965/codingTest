package bronze;

import java.util.Scanner;

public class BJ3053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 반지름
        int R = sc.nextInt();

        // 유클리드 기하학 원 넓이
        double euclideanArea = Math.PI * R * R;

        // 택시 기하학 원 넓이
        double taxiGeometryArea = 2.0 * R * R;

        System.out.printf("%.6f\n", euclideanArea);
        System.out.printf("%.6f\n", taxiGeometryArea);
    }
}
