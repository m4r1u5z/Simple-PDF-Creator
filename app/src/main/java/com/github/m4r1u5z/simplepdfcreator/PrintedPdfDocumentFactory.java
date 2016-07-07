package com.github.m4r1u5z.simplepdfcreator;

import android.app.Activity;
import android.print.PrintAttributes;
import android.print.pdf.PrintedPdfDocument;

/**
 * Created by mariusz on 06.07.16
 */
public class PrintedPdfDocumentFactory {
    protected PrintedPdfDocument generateDocument(Activity activity, PrintAttributes attributes) {
        return new PrintedPdfDocument(activity, attributes);
    }
}
