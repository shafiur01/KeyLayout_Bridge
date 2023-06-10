package graphs;

import java.util.Set;

public interface Graph<VT>
{
	//part of post: rv != null
	//part of post: !rv.contains(null)
	public Set<VT> getVertexSet();
	
	//part of pre: source != null
	//part of pre: destination != null
	//part of pre: getVertexSet().contains(source)
	//part of pre: getVertexSet().contains(destination)
	public boolean hasEdge(VT source, VT destination);
}