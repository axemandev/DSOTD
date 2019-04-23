package prj.dsotd.simplegraph;

import prj.dsotd.simplegraph.model.DirectionType;
import prj.dsotd.simplegraph.model.Edge;
import prj.dsotd.simplegraph.model.Graph;
import prj.dsotd.simplegraph.model.GraphType;
import prj.dsotd.simplegraph.model.Vertex;

public class DSTest {
	public static void main(String[] args) {	
		Graph graph = GraphFactory.createGraph(GraphType.ADJACENCY_MATRIX, DirectionType.UNDIRECTED);
		graph.addVertex(new Vertex("SubhardaGoke", 150));
		graph.addVertex(new Vertex("DimantuDhotrika", 32));
		graph.addVertex(new Vertex("RaghmaanBuzkaashi", 234));
		graph.addVertex(new Vertex("JoffriBandast", 2323894));
		Edge edge1 = new Edge(graph.getVertex("SubhardaGoke"), graph.getVertex("RaghmaanBuzkaashi"), 2350);
		Edge edge2 = new Edge(graph.getVertex("DimantuDhotrika"), graph.getVertex("RaghmaanBuzkaashi"), 5520);
		Edge edge3 = new Edge(graph.getVertex("SubhardaGoke"), graph.getVertex("JoffriBandast"), 50235);
		graph.addEdge(edge1);
		graph.addEdge(edge2);
		graph.addEdge(edge3);
		graph.printGraph();
		graph.removeEdge(edge3);
		graph.printGraph();
	}
}
