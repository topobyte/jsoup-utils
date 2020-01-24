// Copyright 2018 Sebastian Kuerten
//
// This file is part of jsoup-utils.
//
// jsoup-elements is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// jsoup-elements is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with jsoup-elements. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.jsoup;

import de.topobyte.jsoup.components.Form;
import de.topobyte.jsoup.components.Input;
import de.topobyte.jsoup.components.Input.Type;
import de.topobyte.jsoup.components.Option;
import de.topobyte.jsoup.components.Select;

public class FormUtil
{

	public static Input addHidden(Form form, String name, String value)
	{
		Input input = form.ac(HTML.input());
		input.setType(Type.HIDDEN);
		input.setName(name);
		input.setValue(value);
		return input;
	}

	public static void addPleaseSelectOption(Select select)
	{
		addPleaseSelectOption(select, "Please select");
	}

	public static void addPleaseSelectOption(Select select, String text)
	{
		Option initialOption = HTML.option();
		select.prependChild(initialOption);
		initialOption.text(text);
		initialOption.setSelected(true);
		initialOption.attr("disabled", true);
		initialOption.attr("hidden", true);
	}

}
