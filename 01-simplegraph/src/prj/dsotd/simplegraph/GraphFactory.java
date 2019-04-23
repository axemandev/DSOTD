package prj.dsotd.simplegraph;

import prj.dsotd.simplegraph.impl.AdjacencyMatrix;
import prj.dsotd.simplegraph.model.DirectionType;
import prj.dsotd.simplegraph.model.Graph;
import prj.dsotd.simplegraph.model.GraphType;

public class GraphFactory {

	public static Graph createGraph(GraphType graphType) {
		return createGraph(graphType, DirectionType.UNDIRECTED);
	}
	
	public static Graph createGraph(GraphType graphType, DirectionType directionType) {
		switch (graphType) {
		case ADJACENCY_MATRIX:
			return new AdjacencyMatrix(directionType);
		case ADJACENCY_SET:
			return null;
		case ADJACNECY_LIST:
			return null;
		default:
			return null;
		}
	}
}
