package de.topobyte.jsoup;

import java.io.File;

public interface PageGeneratorFactory
{

	public Generatable create(File file);

}
