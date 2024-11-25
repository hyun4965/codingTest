import java.util.Arrays;
import java.util.HashSet;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2,1,3,4,1};
        System.out.println(solution("one4seveneight"));
    }

    public static int solution(String s) {
        String[] str = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < str.length; i++){
            s = s.replace(str[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }
}