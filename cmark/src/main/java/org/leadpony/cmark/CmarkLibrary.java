package org.leadpony.cmark;

import java.nio.charset.StandardCharsets;

import com.sun.jna.Native;
import com.sun.jna.Pointer;

public class CmarkLibrary {

    static {
        Native.register("cmark");
    }
    
    public static native Pointer cmark_markdown_to_html(byte[] text, int len, int options);

    public static String renderToHtml(String text, int options) {
        byte[] input = text.getBytes(StandardCharsets.UTF_8);
        Pointer p = cmark_markdown_to_html(input, input.length, options);
        String result = p.getString(0, "UTF8");
        Native.free(Pointer.nativeValue(p));
        return result;
    }
}
