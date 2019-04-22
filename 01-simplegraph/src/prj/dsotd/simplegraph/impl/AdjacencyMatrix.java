package prj.dsotd.simplegraph.impl;

import java.util.ArrayList;
import java.util.List;

import prj.dsotd.simplegraph.model.Edge;
import prj.dsotd.simplegraph.model.Graph;
import prj.dsotd.simplegraph.model.Vertex;

public class AdjacencyMatrix implements Graph {

	private List<Vertex> vertices;
	private List<List<Long>> adjacencyMatrix;
	
	@Override
	public Boolean areAdjacent(Vertex x, Vertex y) {
		return null;
	}

	@Override
	public List<Vertex> neighbours(Vertex x, Integer level) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Boolean addVertex(Vertex x) {
		
		// add to list of vertices
		this.vertices.add(x);
		this.initNewEdges();
		
		return null;
	}

	@Override
	public Boolean removeVertex(Vertex x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean addEdge(Edge e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean removeEdge(Edge e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getVertexValue(Vertex x) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setVertexValue(Vertex x, Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Edge> getEdges(Vertex source, Vertex destination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getEdgeValue(Edge e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEdgeValue(Edge e, Long weight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long shortestDistance(Vertex source, Vertex destination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getSize() {
		return Long.parseLong(String.valueOf(vertices.size()));
	}
	
	private Long initEdgeValue() {
		return null;
	}
	
	private void initNewEdges() {
		// set rows and cols for new vertex to null
		// if first vertex, handle separtely
		Long value = initEdgeValue();
		Long size = this.getSize();
		if (size == 1) {
			List<Long> cols = new ArrayList<>();
			cols.add(value);
			adjacencyMatrix.add(cols);
		}
		else {
			// traverse through each row and add a new col.
			for (List<Long> row : adjacencyMatrix) {
				row.add(value);
			}
			// finally add a new row for new vertex
			List<Long> newRow = new ArrayList<>();
			for(Long i=0L; i<size; i++) {
				newRow.add(initEdgeValue());
			}
			adjacencyMatrix.add(newRow);
		}
	}

}
