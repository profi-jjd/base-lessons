package com.profi.jjd.lesson20.masks;

public class Mask {
    public static void main(String[] args) {
        // PHOTO 0001
        // VIDEO 0010
        // AUDIO 0100
        // FILE 1000

        User user = new User();
        // установить разрешения на работу с FILE и PHOTO
        user.setPermissions(Permissions.FILE | Permissions.PHOTO);
        // побитовое или |
        //    1000
        //    0001
        //int 1001

        // проверить наличие разрешений (пересечение масок)
        if ((user.getPermissions() & Permissions.AUDIO) != Permissions.AUDIO){
            System.out.println("У Вас нет разрешений на работу с аудио");
        } else {
            System.out.println("Доступ на работу с аудио открыт");
        }
        // 1001 user mask
        // 0100 AUDIO mask
        // 0000 - 0100

        if ((user.getPermissions() & Permissions.FILE) != Permissions.FILE){
            System.out.println("У Вас нет разрешений на работу с аудио");
        } else {
            System.out.println("Доступ на работу с аудио открыт");
        }
        // 1001
        // 1000
        // 1000 != 1000

        // исключить разрешение на работу с файлами
        user.setPermissions(user.getPermissions() & ~Permissions.FILE);
        //         1001 user mask
        // 1000 -> 0111
        //         0001

    }
}
