package com.github.m4r1u5z.simplepdfcreator;

import android.content.Context;
import android.print.PrintAttributes;

/**
 * Created by mariusz on 06.07.16
 */
public class PrintAttributesFactory {
    protected PrintAttributes generateAttributes() {
        return new PrintAttributes.Builder().
                setColorMode(PrintAttributes.COLOR_MODE_COLOR).
                setMediaSize(PrintAttributes.MediaSize.NA_LETTER).
                setMinMargins(PrintAttributes.Margins.NO_MARGINS).
                build();
    }

    protected PrintAttributes generateAttributes(int width, int height) {
        return new PrintAttributes.Builder().
                setColorMode(PrintAttributes.COLOR_MODE_COLOR).
                setMediaSize(PrintAttributes.MediaSize.NA_LETTER).
                setMinMargins(PrintAttributes.Margins.NO_MARGINS).
                setResolution(new PrintAttributes.Resolution("pdf", Context.PRINT_SERVICE, width, height)).
                build();
    }

    protected PrintAttributes generateAttributes(PrintAttributes.Resolution resolution) {
        return new PrintAttributes.Builder().
                setColorMode(PrintAttributes.COLOR_MODE_COLOR).
                setMediaSize(PrintAttributes.MediaSize.NA_LETTER).
                setMinMargins(PrintAttributes.Margins.NO_MARGINS).
                setResolution(resolution).
                build();
    }
}
