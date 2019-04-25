package prj.dsotd.simplegraph.model;

import java.util.List;

public interface Graph {

	public Boolean areAdjacent(Vertex x, Vertex y);
	public List<Vertex> neighbours(Vertex x, Integer level);
	public Boolean addVertex(Vertex x);
	public Vertex addVertex(String name, Object value);
	public Boolean removeVertex(Vertex x);
	public Boolean removeVertex(String name);
	public Boolean addEdge(Edge e);
	public Boolean addEdge(Object ... args);
//	public Boolean addEdge(Object source, Object destination, Double weight, DirectionType directionType);
	public Boolean removeEdge (Edge e);
	public Boolean removeEdge(Object source, Object destination);
	public Object getVertexValue(Vertex x);
	public void setVertexValue(Vertex x, Object obj);
	public List<Edge> getEdges(Vertex source, Vertex destination);
//	public List<Edge> getIn
	public Double getEdgeValue(Edge e);
	public void setEdgeValue(Edge e, Double weight);
	public Double shortestDistance(Vertex source, Vertex destination);
	public Integer getSize();
	public void print();
	public Vertex getVertex(String name);
	public DirectionType directionType();
	public Boolean isDirected();
}
