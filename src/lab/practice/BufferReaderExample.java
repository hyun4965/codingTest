package lab.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferReaderExample {
    public static void main(String[] args) {
        try(
                BufferedReader br = new BufferedReader(new FileReader("test.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("Copy_test.txt"));
        ){
            String line;
            while((line = br.readLine())!=null){
                bw.write(line);
                bw.newLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
