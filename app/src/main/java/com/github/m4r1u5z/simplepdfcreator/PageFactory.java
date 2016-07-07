package com.github.m4r1u5z.simplepdfcreator;

import android.graphics.pdf.PdfDocument;
import android.print.pdf.PrintedPdfDocument;
import android.view.View;

/**
 * Created by mariusz on 06.07.16
 */
public class PageFactory {
    protected void generatePage(View view, PrintedPdfDocument printedPdfDocument) {
        PdfDocument.Page page = printedPdfDocument.startPage(0);
        preparePage(view, page);
        finishPage(printedPdfDocument, page);
    }

    private void preparePage(View view, PdfDocument.Page page) {
        view.draw(page.getCanvas());
    }

    private void finishPage(PrintedPdfDocument document, PdfDocument.Page page) {
        document.finishPage(page);
    }
}
