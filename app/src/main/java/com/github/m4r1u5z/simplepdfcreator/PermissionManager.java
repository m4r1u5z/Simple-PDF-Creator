package com.github.m4r1u5z.simplepdfcreator;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by mariusz on 06.07.16
 */
public class PermissionManager {

    private static final int PERMISSION_REQUEST_CODE = 100;
    private static final String PDF_PERMISSION = Manifest.permission.WRITE_EXTERNAL_STORAGE;

    protected static boolean checkPermission(Activity activity) {
        int permissionCheck = ContextCompat.checkSelfPermission(activity,
                PDF_PERMISSION);
        return permissionCheck == PackageManager.PERMISSION_GRANTED;
    }

    protected static void showPermissionWindow(Activity activity) {
        ActivityCompat.requestPermissions(activity,
                new String[]{PDF_PERMISSION},
                PERMISSION_REQUEST_CODE);
    }

    protected static boolean isValidPermissionGranted(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        return isValidPermission(permissions)
                && isPermissionGranted(requestCode, grantResults[0]);
    }

    private static boolean isValidPermission(String[] permissions) {
        return permissions[0].equals(PDF_PERMISSION);
    }

    private static boolean isPermissionGranted(int requestCode, int grantResults) {
        return requestCode == PERMISSION_REQUEST_CODE && grantResults == 0;
    }
}
