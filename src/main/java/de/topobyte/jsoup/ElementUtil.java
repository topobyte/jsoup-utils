// Copyright 2016 Sebastian Kuerten
//
// This file is part of jsoup-utils.
//
// jsoup-elements is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// jsoup-elements is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with jsoup-elements. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.jsoup;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.parser.Parser;

public class ElementUtil
{

	public static void appendFragment(Element e, String fragment)
	{
		Element doc = Jsoup.parse(fragment);
		appendFragment(e, doc);
	}

	public static void appendFragment(Element e, String fragment,
			Element context)
	{
		List<Node> nodes = Parser.parseFragment(fragment, context, "");
		appendFragment(e, new ArrayList<>(nodes));
	}

	public static void appendFragmentHead(Element e, String fragment)
	{
		Element head = Jsoup.parse(fragment).head();
		appendFragment(e, head);
	}

	public static void appendFragmentBody(Element e, String fragment)
	{
		Element body = Jsoup.parse(fragment).body();
		appendFragment(e, body);
	}

	public static void appendFragment(Element e, Element fragment)
	{
		List<Node> nodes = new ArrayList<>();
		nodes.addAll(fragment.childNodes());
		appendFragment(e, nodes);
	}

	public static void appendFragment(Element e, List<? extends Node> nodes)
	{
		for (Node child : nodes) {
			e.appendChild(child);
		}
	}

}
