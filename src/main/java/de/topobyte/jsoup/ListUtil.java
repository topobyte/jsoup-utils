// Copyright 2018 Sebastian Kuerten
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

import de.topobyte.jsoup.components.A;
import de.topobyte.jsoup.components.List;
import de.topobyte.jsoup.components.ListItem;

public class ListUtil
{

	public static void add(List list, String href)
	{
		A link = HTML.a(href);
		link.appendText(href);
		list.addItem(link);
	}

	public static void add(List list, String href, String text)
	{
		A link = HTML.a(href);
		link.appendText(text);
		list.addItem(link);
	}

	public static void add(List list, String prefix, String href, String text)
	{
		A link = HTML.a(href);
		link.appendText(text);
		ListItem item = list.addItem();
		item.appendText(prefix);
		item.ac(link);
	}

}
