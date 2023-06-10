package graphs;

import java.util.*;

public class GraphCompleteImpl_Shafiur<VT> extends GraphAbstract<VT> implements Graph<VT>
{
	//Student: Select your own internal representation and associated instance variables
	Map<VT, Set<VT>> internalMap = new HashMap<VT, Set<VT>>();
	Set<VT> initialSet = new HashSet<VT>();
	
	
	//part of pre: vertexSet != null
	//part of pre: !vertexSet.contains(null)
	public GraphCompleteImpl_Shafiur(Set<VT> vertexSet)
	{
		assert vertexSet!=null : "The vertexSet can't be null";
		assert !vertexSet.contains(null) : "The vertex set can't contain null";	
		
		for(VT element: vertexSet)
		{
			Set<VT> temporarySet = new HashSet<VT>(vertexSet);
			VT temp = element;
			temporarySet.remove(element);
			internalMap.put(temp, temporarySet);
		}
		
		this.initialSet = vertexSet;
	}

	
	public Set<VT> getVertexSet()
	{
		assert !internalMap.containsValue(null): "The value of the map can't be null";
		assert !internalMap.containsKey(null) : "The key can't be null";
		// making a return set from the key-values of the map. Because the map should have all the vertexSet element passed.
		Set<VT> returnSet = new HashSet<VT>(internalMap.keySet());
		return returnSet;
	}

	
	
	
	//part of pre: source != null
	//part of pre: destination != null
	//part of pre: getVertexSet().contains(source)
	//part of pre: getVertexSet().contains(destination)
	@Override
	public boolean hasEdge(VT source, VT destination)
	{
		// either of the source and the destination can't be null, and the internal map should contain both of the source and destination
		assert source!=null : "The source can't be null";
		assert destination!=null : "The destination can't be null";
		assert initialSet.contains(source): "The initial set doesn't contain the source";
		assert initialSet.contains(destination): "The initial set doesn't contain the destination";

		
		boolean hasEdge = false;
		Set<VT> adjacencyVerticesSet =  internalMap.get(source); // 1 = [2,3,4,5]

		boolean doesContainDestinaiton = adjacencyVerticesSet.contains(destination);

		if(!doesContainDestinaiton)
		{
			hasEdge = false;
		}
		else
		{
			hasEdge = true;
		}
		
		return hasEdge;
	}
	
	
}
