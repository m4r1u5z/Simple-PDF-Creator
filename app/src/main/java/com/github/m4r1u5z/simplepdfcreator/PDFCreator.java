package com.github.m4r1u5z.simplepdfcreator;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;

import java.io.File;

/**
 * Created by mariusz on 06.07.16
 */
public class PDFCreator {

    private PDFCreatorHelper _pdfCreatorHelper;

    public PDFCreator(Activity activity) {
        _pdfCreatorHelper = new PDFCreatorHelper(activity);
    }

    public void create(View view, File path) {
        _pdfCreatorHelper.create(view, path);
    }

    public void create(View view, String path, String fileName) {
        File filePath = PathFactory.getPath(path, fileName);
        create(view, filePath);
    }

    public void create(View view, String path) {
        File filePath = PathFactory.getPath(path);
        create(view, filePath);
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (PermissionManager.isValidPermissionGranted(requestCode, permissions, grantResults)) {
            _pdfCreatorHelper.createPDF();
        }
    }
}
