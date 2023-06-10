package graphs;

import java.util.ArrayList;
import java.util.List;

public abstract class GraphAbstract<VT> implements Graph<VT>
{
	private static final String INFO = "Plug the following in to http://webgraphviz.com/:";
	private static final String BEGIN = "{";
	private static final String END = "}";
	private static final String NEWLINE = "\n";
	private static final String EDGE = "->";
	private static final String ENDOFLINE = ";";
	private static final String TAB = "     ";
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		final String HEADER = "digraph G";
		sb.append(INFO + NEWLINE);
		sb.append(HEADER + " " + BEGIN + NEWLINE);
		
		List<VT> vertices = new ArrayList<VT>(getVertexSet());
		final int VERTEX_COUNT = vertices.size();
		System.out.println(vertices);
		for(int i = 0; i < VERTEX_COUNT; i++)
		{
			VT vertex_i = vertices.get(i);
			sb.append(TAB + "\"" + vertex_i + "\"" + ENDOFLINE + NEWLINE);
			for(int j = 0; j < VERTEX_COUNT; j++)
			{
				VT vertex_j = vertices.get(j);
				boolean hasEdge_ij = hasEdge(vertex_i, vertex_j);
				if(hasEdge_ij)
				{
					sb.append(TAB + "\"" + vertex_i + "\"" + " " + EDGE + " " + "\"" + vertex_j + "\"" + ENDOFLINE + NEWLINE);
				}
			}
		}
		sb.append(END);
		return sb.toString();
	}
}
