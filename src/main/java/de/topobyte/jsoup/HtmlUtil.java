package de.topobyte.jsoup;

import java.awt.Color;

public class HtmlUtil
{

	public static String colorString(Color color)
	{
		int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();
		return String.format("%02x%02x%02x", r, g, b);
	}

	public static void main(String[] args)
	{
		Color color = new Color(0x79FF0e);
		System.out.println(colorString(color));
	}

}
