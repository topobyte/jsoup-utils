package de.topobyte.jsoup;

import java.io.IOException;

public interface Generatable extends Buildable
{

	public void generate() throws IOException;

}
