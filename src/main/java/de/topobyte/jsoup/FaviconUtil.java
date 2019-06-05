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

import static de.topobyte.jsoup.ElementBuilder.create;

import org.jsoup.nodes.Element;

public class FaviconUtil
{

	public static void addToHeader(Element head, String faviconPath)
	{
		Element favicon1 = create("link", "rel", "icon", "type", "image/x-icon",
				"href", faviconPath);
		Element favicon2 = create("link", "rel", "shortcut icon", "type",
				"image/x-icon", "href", faviconPath);
		Element favicon3 = create("link", "type", "image/x-icon", "href",
				faviconPath);
		head.appendChild(favicon1);
		head.appendChild(favicon2);
		head.appendChild(favicon3);
	}

	public static void addToHeader(Element head, String path, int size)
	{
		String sizeDef = size + "x" + size;
		Element favicon = create("link", "rel", "icon", "type", "image/png",
				"sizes", sizeDef, "href", path);
		head.appendChild(favicon);
	}

}
