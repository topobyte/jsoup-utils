package de.topobyte.jsoup.fragments;

import org.jsoup.nodes.Element;

public class HtmlFragment implements FragmentPart {

    private String html;

    public HtmlFragment(String text) {
        this.html = text;
    }

    public String getHtml() {
        return html;
    }

    @Override
    public void appendTo(Element e) {
        e.append(html);
    }

    @Override
    public void prependTo(Element e) {
        e.prepend(html);
    }

    @Override
    public String toString() {
        return html;
    }

}
