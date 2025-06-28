package lab.practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferdStreamExample1 {
    public static void main(String[] args) {
        try(
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream("test.txt"));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("test2.txt"));
        ){
            byte[] buffer = new byte[1024];
            int byteRead;
            while( (byteRead = bis.read(buffer)) != -1){
                bos.write(buffer, 0, byteRead);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
