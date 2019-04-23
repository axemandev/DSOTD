package prj.dsotd.simplegraph.model;

import java.util.List;

public interface Graph {

	public Boolean areAdjacent(Vertex x, Vertex y);
	public List<Vertex> neighbours(Vertex x, Integer level);
	public Boolean addVertex(Vertex x);
	public Boolean removeVertex(Vertex x);
	public Boolean addEdge(Edge e);
	public Boolean addEdge(Object source, Object destination, Integer weight);
	public Boolean removeEdge (Edge e);
	public Boolean removeEdge(Object source, Object destination);
	public Object getVertexValue(Vertex x);
	public void setVertexValue(Vertex x, Object obj);
	public List<Edge> getEdges(Vertex source, Vertex destination);
	public Integer getEdgeValue(Edge e);
	public void setEdgeValue(Edge e, Long weight);
	public Integer shortestDistance(Vertex source, Vertex destination);
	public Integer getSize();
	public void printGraph();
	public Vertex getVertex(String name);
	public DirectionType directionType();
	public Boolean isDirected();
}
