package lab.watch;

import java.nio.file.*;

public class MyWatchService {
    public static void main(String[] args) {
        try{
            WatchService watchService = FileSystems.getDefault().newWatchService();
            Path path = Paths.get("C:\\Users\\bjh49\\Downloads");
            path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_CREATE);
            WatchKey key;
            while ((key = watchService.take()) != null) {
                for (WatchEvent<?> event : key.pollEvents()) {
                    System.out.println("Event kind:" + event.kind()
                            + ". File affected: " + event.context() + ".");
                }
                key.reset();
            }
        }catch (Exception e){

        }
    }
}
