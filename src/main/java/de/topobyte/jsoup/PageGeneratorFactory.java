package de.topobyte.jsoup;

import de.topobyte.webpaths.WebPath;

public interface PageGeneratorFactory
{

	public ContentGeneratable create(WebPath path);

}
