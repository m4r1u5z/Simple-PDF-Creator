package com.github.m4r1u5z.simplepdfcreator;

import android.app.Activity;
import android.print.PrintAttributes;
import android.print.pdf.PrintedPdfDocument;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by mariusz on 06.07.16
 */
public class PDFCreatorHelper {

    private Activity _activity;
    private PrintedPdfDocument _document;
    private File _path;

    private PrintAttributesFactory _printAttributesFactory;
    private PrintedPdfDocumentFactory _printedPdfDocumentFactory;
    private PageFactory _pageFactory;

    protected PDFCreatorHelper(Activity activity) {
        _activity = activity;

        _printAttributesFactory = new PrintAttributesFactory();
        _printedPdfDocumentFactory = new PrintedPdfDocumentFactory();
        _pageFactory = new PageFactory();
    }

    protected void create(View view, File path) {
        _path = path;
        prepareFolder(path);
        prepareDocument(view);
        createIfGranted();
    }

    private void prepareFolder(File path) {
        FolderCreator.createNeccessaryFolders(path);
    }

    private void prepareDocument(View view) {
        PrintAttributes attributes = _printAttributesFactory.generateAttributes();
        _document = _printedPdfDocumentFactory.generateDocument(_activity, attributes);
        _pageFactory.generatePage(view, _document);
    }

    protected void createIfGranted() {
        if (PermissionManager.checkPermission(_activity)) {
            createPDF();
        } else {
            PermissionManager.showPermissionWindow(_activity);
        }
    }

    protected void createPDF() {
        try {
            FileOutputStream fos = new FileOutputStream(_path);
            _document.writeTo(fos);
            _document.close();
            fos.close();
            showToast(_activity.getString(R.string.create_status_success));
        } catch (IOException ignored) {
            showToast(_activity.getString(R.string.create_status_fail));
        }
    }

    private void showToast(String message) {
        Toast.makeText(_activity, message, Toast.LENGTH_SHORT).show();
    }
}
