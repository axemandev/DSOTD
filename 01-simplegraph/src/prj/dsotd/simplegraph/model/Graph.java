package prj.dsotd.simplegraph.model;

import java.util.List;

public interface Graph {

	public Boolean areAdjacent(Vertex x, Vertex y);
	public List<Vertex> neighbours(Vertex x, Integer level);
	public Boolean addVertex(Vertex x);
	public Boolean removeVertex(Vertex x);
	public Boolean addEdge(Edge e);
	public Boolean removeEdge (Edge e);
	public Object getVertexValue(Vertex x);
	public void setVertexValue(Vertex x, Object obj);
	public List<Edge> getEdges(Vertex source, Vertex destination);
	public Long getEdgeValue(Edge e);
	public void setEdgeValue(Edge e, Long weight);
	public Long shortestDistance(Vertex source, Vertex destination);
	public Long getSize();
}
