package com.profi.jjd.lesson20;


import java.io.IOException;
import java.nio.file.*;

public class WatchersExample {
    public static void main(String[] args) throws IOException, InterruptedException {

        // создание объекта WatchService (будет следить за событиями по указанному в дальнейшем пути)
        WatchService watchService =
                FileSystems.getDefault().newWatchService();

        // создаем объект типа Path
        Path path = Paths.get("exams"); //args[0]

        // регистрируем path в WatchService на события: создание / удаление / изменение
        path.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        WatchKey key;
        // получаем ключ
        while ((key = watchService.take()) != null) {
            // получаем список произошедших событий
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println(event.kind() + " : " + event.context());
            }
            key.reset();
        }

    }
}


