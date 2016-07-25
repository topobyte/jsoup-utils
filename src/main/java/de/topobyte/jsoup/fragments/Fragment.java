package de.topobyte.jsoup.fragments;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

import com.google.common.collect.Lists;

/**
 * A sequence of Content nodes.
 */
public class Fragment
{

	public static Fragment text(String text)
	{
		Fragment fragment = new Fragment();
		fragment.addText(text);
		return fragment;
	}

	public static Fragment raw(String html)
	{
		Fragment fragment = new Fragment();
		fragment.addHtml(html);
		return fragment;
	}

	public static Fragment node(Node node)
	{
		Fragment fragment = new Fragment();
		fragment.add(node);
		return fragment;
	}

	protected List<FragmentPart> contents = new ArrayList<>();

	public Fragment addText(String text)
	{
		contents.add(new TextFragment(text));
		return this;
	}

	public Fragment addHtml(String html)
	{
		contents.add(new HtmlFragment(html));
		return this;
	}

	public Fragment add(Node node)
	{
		contents.add(new NodeFragment(node));
		return this;
	}

	public Fragment add(Fragment fragment)
	{
		for (FragmentPart part : fragment.contents) {
			contents.add(part);
		}
		return this;
	}

	public void addContent(String text)
	{
		if (text.isEmpty()) {
			return;
		}
		contents.add(new TextFragment(text));
	}

	public boolean isEmpty()
	{
		return contents.isEmpty();
	}

	public int charCount()
	{
		return 0;
	}

	@Override
	public String toString()
	{
		StringBuilder buffer = new StringBuilder();
		for (FragmentPart part : contents) {
			buffer.append(part.toString());
		}
		return buffer.toString();
	}

	public <E extends Element> E appendTo(E e)
	{
		for (FragmentPart content : contents) {
			content.appendTo(e);
		}
		return e;
	}

	public static <E extends Element> E append(E e, Fragment fragment)
	{
		return fragment.appendTo(e);
	}

	public <E extends Element> E prependTo(E e)
	{
		for (FragmentPart content : Lists.reverse(contents)) {
			content.prependTo(e);
		}
		return e;
	}

	public static <E extends Element> E prepend(E e, Fragment fragment)
	{
		return fragment.prependTo(e);
	}

}
