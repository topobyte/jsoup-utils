package de.topobyte.jsoup.fragments;

import org.jsoup.nodes.Element;

public interface FragmentPart
{

	public void appendTo(Element e);

	public void prependTo(Element e);

}
