package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import combinatorics.Permutation;

public class GraphPermutedImpl_Shafiur<VT> extends GraphAbstract<VT> implements Graph<VT> {
	// Student: Select your own internal representation and associated instance
	// variables

	// part of pre: graph != null
	// part of pre: permutation != null
	// part of pre: graph.getVertexSet() equals permutation.getDomain()
	Graph<VT> graph;
	Map<VT, Set<VT>> graphMap;
	Map<VT, Set<VT>> translatedImageMap;

	public GraphPermutedImpl_Shafiur(Graph<VT> graph, Permutation<VT> permutation) {
		assert (graph != null) : "graph = null";
		assert (permutation != null) : "permutation = null";
		assert (graph.getVertexSet().equals(permutation.getDomain())) : "graph and permutation not same vertex/domain";

		graphMap = new HashMap<>();
		translatedImageMap = new HashMap<>();
		this.graph = graph;

		for (VT vertexStudy : graph.getVertexSet()) {
			Set<VT> edgesVertexStudy = new HashSet<>();

			for (VT currentVertex : graph.getVertexSet()) {
				boolean vertesImageFound = (graph.hasEdge(vertexStudy, currentVertex));

				if (vertesImageFound) {
					edgesVertexStudy.add(currentVertex);
				}
			}
			graphMap.put(vertexStudy, edgesVertexStudy);
		}

		for (VT realVertex : graphMap.keySet()) {
			Set<VT> newImagesOfVertex = new HashSet<>();

			for (VT iamgeOfRealVertex : graphMap.get(realVertex)) {
				newImagesOfVertex.add(permutation.getImage(iamgeOfRealVertex));
			}
			translatedImageMap.put(permutation.getImage(realVertex), newImagesOfVertex);
		}
	}

	@Override
	public Set<VT> getVertexSet() {
		return graph.getVertexSet();
	}

	@Override
	public boolean hasEdge(VT source, VT destination) {
		// Student: Figure out all preconditions and make them executable
		assert (graph.getVertexSet().contains(source)) : "Does not contain source";
		assert (graph.getVertexSet().contains(destination)) : "destination not in it";

		boolean sourceSetContainsSet = translatedImageMap.get(source).contains(destination);

		return sourceSetContainsSet;
	}
}
