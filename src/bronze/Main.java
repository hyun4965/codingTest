package bronze;
//import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("덧셈할 문자열을 입력해 주세요.\n");
        Scanner scanner = new Scanner(System.in);
        String input = null;
        try {
            input = scanner.nextLine();
        } catch (NoSuchElementException e) {
            System.err.println("입력이 없습니다. 프로그램을 종료합니다.");
            return;
        }

        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String division = ",|:";
        String numbers = input;

        if (input.startsWith("//")) {
            int division_index = input.indexOf("\n");
            if (division_index == -1) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
            division = input.substring(2, division_index);
            numbers = input.substring(division_index + 1);
        }

        String[] tokens = numbers.split(division);
        Queue<Integer> queue = new LinkedList<>();
        for (String token : tokens) {
            int num = Integer.parseInt(token.trim());
            if (num < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + token);
            }
            queue.offer(num);
        }

        int sum = 0;
        while (!queue.isEmpty()) {
            sum += queue.poll();
        }
        return sum;
    }
}

//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Main app = new Main();
//        Scanner in = new Scanner(System.in);
//        System.out.println("입력할 숫자를 입력하세요");
//        String input = in.next();
//        try {
//            int result = app.add(input);
//            System.out.println("결과 : " + result);
//        } catch (IllegalArgumentException e) {
//            System.err.println(e.getMessage());
//        }
//
//    }
//    public int add(String input){
//        if(input == null || input.isEmpty()){
//            return 0;
//        }
//        String character = ",|:";
//        String number = input;
//        if(input.startsWith("//")){
//            int character_index = input.indexOf("\n");
//            if(character_index == -1){
//                throw new IllegalArgumentException("Invalid input format");
//            }
//            character = input.substring(2,character_index);
//            number = input.substring(character_index+1);
//        }
//        String[] tokens = number.split(character);
//        Queue<Integer> queue = new LinkedList<>();
//        for (String token : tokens) {
//            int num = Integer.parseInt(token);
//            if(num<0){
//                throw new IllegalArgumentException("Negative numbers are not allowed: " + number);
//            }
//            queue.offer(num);
//        }
//        int sum = 0;
//        while (!queue.isEmpty()) {
//            sum += queue.poll();
//        }
//        return sum;
//    }
//}
