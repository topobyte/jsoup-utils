package de.topobyte.jsoup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

public class HtmlBuilder
{

	private Document document;
	private Element head;
	private Element body;
	private Element title;

	public HtmlBuilder()
	{
		document = new Document("");

		OutputSettings settings = document.outputSettings();
		settings.charset("UTF-8");
		settings.indentAmount(2);
		settings.prettyPrint(true);
		document.outputSettings(settings);

		document.head();

		Element html = document.createElement("html");
		document.appendChild(html);

		head = document.createElement("head");
		html.appendChild(head);

		title = document.createElement("title");
		head.appendChild(title);

		body = document.createElement("body");
		html.appendChild(body);
	}

	public Document getDocument()
	{
		return document;
	}

	public Element getHeader()
	{
		return head;
	}

	public Element getBody()
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

	public Element createDiv()
	{
		return document.createElement("div");
	}

	public Element createDivWithId(String id)
	{
		return create("div", "id", id);
	}

	public Element createDivWithClass(String className)
	{
		return create("div", "class", className);
	}

	public Element createAnchor(String link)
	{
		Element a = document.createElement("a");
		a.attributes().put("href", link);
		return a;
	}

	public Element create(String tag)
	{
		return document.createElement(tag);
	}

	public Element create(String name, String... arguments)
	{
		Map<String, String> atts = new HashMap<String, String>();
		for (int i = 0; i < arguments.length / 2; i++) {
			String key = arguments[2 * i];
			String val = arguments[2 * i + 1];
			atts.put(key, val);
		}
		return create(name, atts);
	}

	public Element create(String name, Map<String, String> map)
	{
		Element element = document.createElement(name);
		for (Entry<String, String> entry : map.entrySet()) {
			element.attr(entry.getKey(), entry.getValue());
		}
		return element;
	}

	public void setStyle(Element element, String style)
	{
		element.attr("style", style);
	}

	public Element createTextAnchor(String href, String text)
	{
		Element anchor = create("a", "href", href);
		anchor.text(text);
		return anchor;
	}

	public Element styleSheet(String cssHref)
	{
		return create("link", "rel", "stylesheet", "type", "text/css", "href",
				cssHref);
	}

	public Element script(String jsHref)
	{
		return create("script", "src", jsHref);
	}

	public void setTitle(String titleText)
	{
		title.text(titleText);
	}

	public void setDescription(String descriptionText)
	{
		// TODO Auto-generated method stub
	}

	public void setKeywords(String keywordsText)
	{
		// TODO Auto-generated method stub
	}

	public void appendFragment(Element e, String fragment)
	{
		Element body = Jsoup.parse(fragment).body();
		List<Node> nodes = new ArrayList<Node>();
		nodes.addAll(body.childNodes());
		for (Node child : nodes) {
			e.appendChild(child);
		}
	}

}
