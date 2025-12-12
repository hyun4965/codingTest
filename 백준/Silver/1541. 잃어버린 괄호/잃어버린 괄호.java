import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        String[] minusParts = str.split("-");

        int result = 0;

        result += sumOfPlusGroup(minusParts[0]);

        for (int i = 1; i < minusParts.length; i++) {
            result -= sumOfPlusGroup(minusParts[i]);
        }

        System.out.println(result);
    }

    private static int sumOfPlusGroup(String s) {
        String[] plusParts = s.split("\\+");
        int sum = 0;
        for (String numStr : plusParts) {
            sum += Integer.parseInt(numStr);
        }
        return sum;
    }
}