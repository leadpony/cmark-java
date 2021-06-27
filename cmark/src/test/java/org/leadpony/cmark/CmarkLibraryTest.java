package org.leadpony.cmark;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CmarkLibraryTest {

    @Test
    public void renderToHtmlShouldRenderSimpleText() {
        String html = CmarkLibrary.renderToHtml("This is *Sparta*", 0);
        assertThat(html).isEqualTo("<p>This is <em>Sparta</em></p>\n");
    }

    @Test
    public void renderToHtmlShouldRenderUnicode() {
        String html = CmarkLibrary.renderToHtml("The author is *村上春樹*", 0);
        assertThat(html).isEqualTo("<p>The author is <em>村上春樹</em></p>\n");
    }
}
