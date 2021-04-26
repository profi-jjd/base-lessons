package com.profi.jjd.lesson18.handlers;

import java.io.File;

abstract public class FileHandler {
    protected File file;

    abstract public boolean writeToFile(byte[] data);
    abstract public byte[] readFromFile();
}


