// Copyright 2021 Sebastian Kuerten
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

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;

import de.topobyte.jsoup.components.Body;
import de.topobyte.jsoup.components.Form;
import de.topobyte.jsoup.components.Head;
import de.topobyte.jsoup.components.Input;
import de.topobyte.jsoup.components.Input.Type;
import de.topobyte.jsoup.components.P;

public class TestFragments
{

	@Test
	public void test() throws IOException
	{
		HtmlBuilder builder = new HtmlBuilder();

		Head head = builder.getHead();

		String header = content("jquery.headers.html");
		System.out.println(header);
		ElementUtil.appendFragment(head, header, HTML.head());

		Body body = builder.getBody();

		body.ac(HTML.h1("JSoup and jQuery"));

		P p = body.ac(HTML.p());
		p.appendText(
				"The input below should be focussed when this page is loaded");

		Form form = body.ac(HTML.form());
		Input input = form.ac(HTML.input());
		input.setType(Type.TEXT);
		input.setId("an-input");

		StringBuilder code = new StringBuilder();

		code.append("$(function() {");
		code.append("  $(\"#");
		code.append("an-input");
		code.append("\").focus();");
		code.append("});");

		body.ac(HTML.script()).ac(new DataNode(code.toString()));

		p = body.ac(HTML.p());
		p.appendText("Lorem ipsum...");

		Document doc = builder.getDocument();
		System.out.println(doc);

		builder.write(new File("/tmp/jsoup-utils.html"));

		String expected = content("test-result.html");
		Assert.assertEquals(expected, doc.toString());
	}

	private static String content(String resource) throws IOException
	{
		return IOUtils.toString(Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(resource));
	}

}
