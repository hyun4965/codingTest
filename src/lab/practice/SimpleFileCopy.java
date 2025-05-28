package lab.practice;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;

public class SimpleFileCopy {
    public static void main(String[] args) {
        Path source = Paths.get("source.txt");
        Path target = Paths.get("copy.txt");
        //Root에 저장해야함 ex) codingTest 여기 제일 상위 디렉토리에

        try (
                FileChannel inChannel = FileChannel.open(source, StandardOpenOption.READ);
                FileChannel outChannel = FileChannel.open(target,
                        StandardOpenOption.CREATE,
                        StandardOpenOption.WRITE,
                        StandardOpenOption.TRUNCATE_EXISTING) //파일이 존재하면 truncate한다.
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (inChannel.read(buffer) != -1) {
                buffer.flip(); // 읽기 모드로 전환
                outChannel.write(buffer);
                buffer.clear(); // 다음 read를 위해 초기화
            }

            System.out.println("복사 완료!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
