package prj.dsotd.simplegraph.impl;

import java.util.ArrayList;
import java.util.List;

import prj.dsotd.simplegraph.model.DirectionType;
import prj.dsotd.simplegraph.model.Edge;
import prj.dsotd.simplegraph.model.Graph;
import prj.dsotd.simplegraph.model.Vertex;

public class AdjacencyMatrix implements Graph {

	private List<Vertex> vertices;
	private List<Edge> edges;
	private List<List<Integer>> adjacencyMatrix;
	private DirectionType directionType;

	public AdjacencyMatrix() {
		vertices = new ArrayList<>();
		edges = new ArrayList<>();
		adjacencyMatrix = new ArrayList<>();
		directionType = DirectionType.UNDIRECTED;
	}
	
	public AdjacencyMatrix(DirectionType directionType) {
		this();
		this.directionType = directionType;
	}

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
		edges.add(e);
		setEdgeWeight(e, e.getWeight());
		return true;
	}

	@Override
	public Boolean removeEdge(Edge e) {
		setEdgeWeight(e, null);
		edges.remove(e);
		return true;
	}

	private void setEdgeWeight(Edge e, Integer weight) {
		int sourceIndex = vertices.indexOf(getVertex(e.getSource().getName()));
		int destinationIndex = vertices.indexOf(getVertex(e.getDestination().getName()));
		// Default to graph direction type if edge direction type is not explicitly set
		DirectionType directionType = e.getDirectionType() == null ? this.directionType : e.getDirectionType();
		
		adjacencyMatrix.get(sourceIndex).set(destinationIndex, weight);
		if (directionType != DirectionType.DIRECTED)
			adjacencyMatrix.get(destinationIndex).set(sourceIndex, weight);
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
	public Integer getEdgeValue(Edge e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEdgeValue(Edge e, Long weight) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer shortestDistance(Vertex source, Vertex destination) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getSize() {
		return vertices.size();
	}

	@Override
	public Vertex getVertex(String name) {
		for (Vertex vertex : vertices) {
			if (vertex.getName().equals(name))
				return vertex;
		}
		return null;
	}

	private Integer initEdgeValue() {
		return null;
	}

	private void initNewEdges() {
		// set rows and cols for new vertex to null
		// if first vertex, handle separtely
		Integer value = initEdgeValue();
		Integer size = this.getSize();
		if (size == 1) {
			List<Integer> cols = new ArrayList<>();
			cols.add(value);
			adjacencyMatrix.add(cols);
		} else {
			// traverse through each row and add a new col.
			for (List<Integer> row : adjacencyMatrix) {
				row.add(value);
			}
			// finally add a new row for new vertex
			List<Integer> newRow = new ArrayList<>();
			for (Integer i = 0; i < size; i++) {
				newRow.add(initEdgeValue());
			}
			adjacencyMatrix.add(newRow);
		}
	}

	public void printGraph() {
		int loopCounter = 0;
		// setting values for formatting
		int maxLabelSize = maxLabelSize(vertices) + 1;
		int valuePadding = Math.max(maxLabelSize, maxValueSize(adjacencyMatrix) + 1);
		System.out.print(rpad(" ", maxLabelSize));
		for (Vertex vertex : vertices)
			System.out.print(rpad(vertex.getName(), valuePadding));
		System.out.println();

		for (List<Integer> list : adjacencyMatrix) {
			System.out.print(rpad(vertices.get(loopCounter++).getName() + " ", maxLabelSize));
			for (Integer value : list) {
				System.out.print(rpad(value + " ", valuePadding));
			}
			System.out.println(" ");
		}
		System.out.println(" ");
	}

	private String rpad(String string, Integer offset) {
		return String.format("%-" + offset + "s", string);
	}

	private int maxLabelSize(List<Vertex> vertices) {
		int maxSize = 0;
		for (Vertex v : vertices) {
			maxSize = v.getName().length() > maxSize ? v.getName().length() : maxSize;
		}
		return maxSize;
	}

	private int maxValueSize(List<List<Integer>> adjacencyMatrix) {
		int maxSize = 0;
		for (List<Integer> rows : adjacencyMatrix) {
			for (Integer value : rows) {
				int length = (value == null) ? "null".length() : String.valueOf(value).length();
				maxSize = length > maxSize ? length : maxSize;
			}
		}
		return maxSize;
	}

	@Override
	public DirectionType directionType() {
		return directionType;
	}

	@Override
	public Boolean isDirected() {
		return directionType == DirectionType.DIRECTED;
	}

	@Override
	public Boolean addEdge(Object source, Object destination, Integer weight) {
		Vertex sourceVertex = getVertex(source.toString());
		Vertex destinationVertex = getVertex(destination.toString());
		addEdge(new Edge(sourceVertex, destinationVertex, weight));
		return true;
	}

	@Override
	public Boolean removeEdge(Object source, Object destination) {
		// TODO Auto-generated method stub
		return null;
	}

}
