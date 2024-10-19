//
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Application {
//    public static void main(String[] args) {
//        Application app = new Application();
//        System.out.println("덧셈할 문자열을 입력해 주세요.\n");
//        String input = Console.readLine();
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
