package de.topobyte.jsoup.fragments;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

public class NodeFragment implements FragmentPart
{

	private Node node;

	public NodeFragment(Node node)
	{
		this.node = node;
	}

	public Node getNode()
	{
		return node;
	}

	@Override
	public void appendTo(Element e)
	{
		e.appendChild(node);
	}

	@Override
	public void prependTo(Element e)
	{
		e.prependChild(node);
	}

	@Override
	public String toString()
	{
		return node.toString();
	}

}
