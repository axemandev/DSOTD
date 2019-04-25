package prj.dsotd.simplegraph;

import prj.dsotd.simplegraph.model.DirectionType;
import prj.dsotd.simplegraph.model.Edge;
import prj.dsotd.simplegraph.model.Graph;
import prj.dsotd.simplegraph.model.GraphType;
import prj.dsotd.simplegraph.model.Vertex;

public class DSTest {
	public static void main(String[] args) {	
		Graph graph = GraphFactory.createGraph(GraphType.ADJACENCY_MATRIX, DirectionType.UNDIRECTED);
		Vertex c = new Vertex("C", 234);
		graph.addVertex(new Vertex("A", 150));
		graph.addVertex(new Vertex("B", 32));
		graph.addVertex(c);
		graph.addVertex(new Vertex("D", 2323894));
		graph.addEdge("A", "C", 2350.0);
		graph.addEdge("A", "D", 50235.0);
		graph.addEdge("B", "D", 5520.0, DirectionType.DIRECTED);
		graph.addEdge(new Edge(graph.getVertex("C"), graph.getVertex("A"), 51235.0, null));
		graph.print();
		/*
		 * graph.removeEdge("A", "D"); graph.print(); graph.removeVertex(c);
		 * graph.print(); graph.removeVertex("B"); graph.print();
		 * graph.removeVertex("D"); graph.print(); graph.removeVertex("A");
		 * graph.print();
		 */
		
		System.out.println(graph.getEdges(graph.getVertex("C"), graph.getVertex("D")));
	}
}
