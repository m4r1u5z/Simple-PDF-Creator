package com.github.m4r1u5z.simplepdfcreator;

import java.io.File;

/**
 * Created by mariusz on 06.07.16
 */
public class FolderCreator {
    protected static void createNeccessaryFolders(File path) {
        String filePath = path.toString();
        String[] paths = filePath.split(File.separator);
        int fileIndex = filePath.indexOf(paths[paths.length - 1]);
        String folders = filePath.substring(0, fileIndex);

        File fileFolders = new File(folders);

        fileFolders.mkdirs();
    }
}
