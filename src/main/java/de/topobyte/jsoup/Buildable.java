package de.topobyte.jsoup;

import java.nio.file.Path;

public interface Buildable
{

	public HtmlBuilder getBuilder();

	public Path getFile();

}
