// Copyright 2017 Sebastian Kuerten
//
// This file is part of jsoup-utils.
//
// jsoup-utils is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// jsoup-utils is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with jsoup-utils. If not, see <http://www.gnu.org/licenses/>.

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
