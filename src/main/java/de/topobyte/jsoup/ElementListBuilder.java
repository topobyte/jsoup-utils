package de.topobyte.jsoup;

import java.io.IOException;
import java.util.List;

import org.jsoup.nodes.Element;

public interface ElementListBuilder
{

	public List<Element> getElement(Buildable buildable) throws IOException;

}
