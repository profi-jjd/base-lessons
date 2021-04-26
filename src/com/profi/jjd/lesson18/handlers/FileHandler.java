package com.profi.jjd.lesson18.handlers;

import java.io.File;
import java.io.IOException;

abstract public class FileHandler {
    protected File file;

    abstract public boolean writeToFile(byte[] data) throws IOException;
    abstract public byte[] readFromFile() throws IOException;
}


