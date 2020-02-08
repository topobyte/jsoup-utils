// Copyright 2020 Sebastian Kuerten
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

package de.topobyte.jsoup;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import org.jsoup.nodes.Element;

public class Exceptions
{

	public static void appendStackTrace(Element element, Throwable e)
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintWriter pw = new PrintWriter(baos);
		e.printStackTrace(pw);
		pw.close();
		String text = baos.toString();
		text = text.replace("\n", "<br>&nbsp;&nbsp;&nbsp;&nbsp;");
		element.append(text);
	}

}
