package com.github.m4r1u5z.simplepdfcreator;

import android.os.Environment;

import java.io.File;

/**
 * Created by mariusz on 06.07.16
 */
public class PathFactory {
    private static final String PDF_FORMAT = ".pdf";

    protected static File getPath(String path) {
        path = modifyPath(path);
        path = modifyFileName(path);
        return new File(Environment.getExternalStorageDirectory().getPath() + path);
    }

    protected static File getPath(String path, String fileName) {
        String concatenatedPath = concatenatePath(path, fileName);
        return getPath(concatenatedPath);
    }

    private static String modifyPath(String path) {
        if (shouldModifyPath(path)) {
            return File.separator + path;
        } else {
            return path;
        }
    }

    private static boolean shouldModifyPath(String path) {
        String firstLetter = path.substring(0,1);
        return !firstLetter.equals(File.separator);
    }

    private static String modifyFileName(String fileName) {
        if (shouldModifyFileName(fileName)) {
            fileName += PDF_FORMAT;
        }
        return fileName;
    }

    private static boolean shouldModifyFileName(String fileName) {
        if (fileName.length() < 5) {
            return true;
        }
        int fileNameLength = fileName.length();
        String lastLetters = fileName.substring(fileNameLength - 4);
        return !lastLetters.equals(PDF_FORMAT);
    }

    private static String concatenatePath(String path, String fileName) {
        return path + File.separator + fileName;
    }
}
