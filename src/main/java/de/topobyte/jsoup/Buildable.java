package de.topobyte.jsoup;

import java.io.File;

import de.topobyte.jsoup.HtmlBuilder;

public interface Buildable
{

	public HtmlBuilder getBuilder();

	public File getFile();

}
