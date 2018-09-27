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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Document.OutputSettings;

import de.topobyte.jsoup.components.Body;
import de.topobyte.jsoup.components.Head;
import de.topobyte.jsoup.components.Html;
import de.topobyte.jsoup.components.Title;

public class HtmlBuilder
{

	private Document document;
	private Html html;
	private Head head;
	private Body body;
	private Title title;

	public HtmlBuilder()
	{
		document = new Document("");

		OutputSettings settings = document.outputSettings();
		settings.charset("UTF-8");
		settings.indentAmount(2);
		settings.prettyPrint(true);
		document.outputSettings(settings);

		html = new Html();
		document.appendChild(html);

		head = html.ac(new Head());
		title = head.ac(new Title());

		body = html.ac(new Body());
	}

	public Document getDocument()
	{
		return document;
	}

	public Html getHtml()
	{
		return html;
	}

	public Head getHead()
	{
		return head;
	}

	public Title getTitle()
	{
		return title;
	}

	public void setTitle(String titleText)
	{
		title.text(titleText);
	}

	public Body getBody()
	{
		return body;
	}

	public void write(File file) throws IOException
	{
		String text = document.toString();
		OutputStream os = new FileOutputStream(file);
		os.write(text.getBytes(Charset.forName("UTF-8")));
		os.close();
	}

	public void write(Path file) throws IOException
	{
		String text = document.toString();
		OutputStream os = Files.newOutputStream(file);
		os.write(text.getBytes(Charset.forName("UTF-8")));
		os.close();
	}

}
