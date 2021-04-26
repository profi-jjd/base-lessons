package com.profi.jjd.lesson18;

import com.profi.jjd.lesson18.handlers.TxtHandler;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class IOLesson {
    public static void main(String[] args) {
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";

        TxtHandler txtHandler = new TxtHandler(new File("file.txt"));
        // StandardCharsets.UTF_8
        System.out.println(txtHandler.writeToFile(text.getBytes()));
    }
}
