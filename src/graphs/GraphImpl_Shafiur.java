package graphs;

import java.util.Map;
import java.util.*;
import java.util.Set;

//EX: Assume Graph graph = <{0->{1, 2}, 1->{3, 4}, 2->{5, 6}, 3->{}, 4->{}, 5->{}, 6-{}>;
//		Then graph.hasEdge(0, 1) --> true
//			 graph.hasEdge(0, 2) --> true
//			 graph.hasEdge(1, 0) --> false
//			 graph.hasEdge(2, 0) --> false
//			 graph.hasEdge(0, 0) --> false
//		and others.
//		And  graph.getVertexSet() --> {0, 1, 2, 3, 4, 5, 6}

//EX: Other graph examples are in the test cases and are rendered in the image
//files in the resources package

public class GraphImpl_Shafiur<VT> extends GraphAbstract<VT> implements Graph<VT> {
	// Student: Select your own internal representation and associated instance
	// variables
	Map<VT, Set<VT>> instanceMap = new HashMap<VT, Set<VT>>();

	// part of pre: vertexToNeighborsMap != null
	// part of pre: !vertexToNeighborsMap.contains(null)
	// part of pre: For each key in vertexToNeighborsMap.keySet():
	// !vertexToNeighborsMap.get(key).contains(null)
	public GraphImpl_Shafiur(Map<VT, Set<VT>> vertexToNeighborsMap) {
		assert vertexToNeighborsMap != null : "The vertexToNeighborMap can't be null";
		assert !vertexToNeighborsMap.containsKey(null) : "The key can't be null";

		Set<VT> vertexSet = new HashSet<VT>(vertexToNeighborsMap.keySet());
		for (VT key : vertexSet) 
		{
			assert !vertexToNeighborsMap.get(key).contains(null) : "No key of the map can be null";
		}
		this.instanceMap = vertexToNeighborsMap;
	}

	@Override
	public Set<VT> getVertexSet() {
		assert !instanceMap.containsValue(null) : "The value of the map can't be null";
		assert !instanceMap.containsKey(null) : "The key can't be null";

		Set<VT> vertexSet = instanceMap.keySet();
		return vertexSet;
	}

	// part of pre: source != null
	// part of pre: destination != null
	@Override
	public boolean hasEdge(VT source, VT destination) {
		assert source != null : "The source can't be null";
		assert destination != null : "The destination can't be null";
		assert instanceMap.containsKey(source) : "The vertex/source is not in the internalMap";
		assert instanceMap.containsKey(destination) : "The destination is not in the internalMap";

		Set<VT> edgeSet = instanceMap.get(source);
		boolean hasEdge = edgeSet.contains(destination);
		return hasEdge;
	}
}
