package de.topobyte.jsoup.fragments;

import org.jsoup.nodes.Element;

public class TextFragment implements FragmentPart
{

	private String text;

	public TextFragment(String text)
	{
		this.text = text;
	}

	public String getText()
	{
		return text;
	}

	@Override
	public void appendTo(Element e)
	{
		e.appendText(text);
	}

	@Override
	public void prependTo(Element e)
	{
		e.prependText(text);
	}

	@Override
	public String toString()
	{
		return text;
	}

}
