package de.topobyte.jsoup;

import java.io.File;

public interface PageGeneratorFactory
{

	public ContentGeneratable create(File file);

}
