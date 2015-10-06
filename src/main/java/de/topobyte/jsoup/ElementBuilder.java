package de.topobyte.jsoup;

import java.io.IOException;

import org.jsoup.nodes.Element;

public interface ElementBuilder
{

	public Element getElement(Buildable buildable) throws IOException;

}
