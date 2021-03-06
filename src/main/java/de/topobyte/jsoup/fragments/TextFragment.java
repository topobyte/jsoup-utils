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
