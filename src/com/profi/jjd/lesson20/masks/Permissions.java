package com.profi.jjd.lesson20.masks;

public class Permissions {
    // 0001
    // 0010
    // 0100
    // 1000
    // 0000 - отсутствие разрешений, 1111 - наличие всех разрешений
    public static final int PHOTO = 1;  // 0001
    public static final int VIDEO = 1 << 1; // 0010
    public static final int AUDIO = 1 << 2; // 0100
    public static final int FILE = 1 << 3; // 1000
}
