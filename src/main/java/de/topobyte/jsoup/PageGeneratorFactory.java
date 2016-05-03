package de.topobyte.jsoup;

import java.nio.file.Path;

public interface PageGeneratorFactory
{

	public ContentGeneratable create(Path file);

}
