package prj.dsotd.simplegraph.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import prj.dsotd.simplegraph.model.DirectionType;
import prj.dsotd.simplegraph.model.Edge;
import prj.dsotd.simplegraph.model.Graph;
import prj.dsotd.simplegraph.model.Vertex;

public class AdjacencyMatrix implements Graph {

	private List<Vertex> vertices;
	private List<Edge> edges;
	private List<List<Double>> adjacencyMatrix;
	private DirectionType directionType;

	private static final Double DEFAULT_INIT_EDGE_WEIGHT = null;

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
	public Vertex addVertex(String name, Object value) {
		Vertex vertex = new Vertex(name, value);
		this.addVertex(vertex);
		return vertex;
	}

	@Override
	public Boolean removeVertex(String name) {
		return removeVertex(getVertex(name));
	}

	@Override
	public Boolean removeVertex(Vertex x) {
		/*
		 * delete vertex from adj matrix get index of vertex in list of vertices and
		 * delete/ row,col[idx] from adj matrix
		 */
		int index = vertices.indexOf(x);
		// delete row
		adjacencyMatrix.remove(index);
		// del cols
		for (List<Double> row : adjacencyMatrix) {
			row.remove(index);
		}

		// remove edges from list
		for (int i = edges.size() - 1; i >= 0; i--) {
			if (edges.get(i).getSource().equals(x) || edges.get(i).getDestination().equals(x))
				edges.remove(i);
		}

		// remove vertex from list
		vertices.remove(index);

		return true;
	}

	@Override
	public Boolean addEdge(Edge e) {
		edges.add(e);
		setEdgeWeight(e, e.getWeight());
		return true;
	}

	@Override
	/*
	 * Object source, Object destination, Double weight, DirectionType directionType
	 */
	public Boolean addEdge(Object... args) {
		try {
			if (!(args.length >= 2)) {
				throw new RuntimeException("ERROR! Source and Destination missing");
			}
			Vertex sourceVertex = (args[0] instanceof String) ? getVertex(args[0].toString()) : (Vertex) args[0];
			Vertex destinationVertex = (args[1] instanceof String) ? getVertex(args[1].toString()) : (Vertex) args[1];
			Double weight = args.length >= 3 ? (Double)args[2] : 0.0; 
			DirectionType directionType = args.length >= 4 ? (DirectionType)args[3] : this.directionType; 
			addEdge(new Edge(sourceVertex, destinationVertex, weight, directionType));
			return true;
		} catch (ClassCastException e) {
			System.out.println("ERROR! Pass correct list of arguments.");
			System.out.println("addEdge(String_or_Vertex, String_or_Vertex, [Double], [DirectionType])");
			throw e;
		}
	}

	@Override
	public Boolean removeEdge(Edge e) {
		setEdgeWeight(e, null);
		edges.remove(e);
		return true;
	}

	@Override
	public Boolean removeEdge(Object source, Object destination) {
		return removeEdge(this.getEdge(source.toString(), destination.toString()));
	}

	@Override
	public Object getVertexValue(Vertex x) {
		return x.getValue();
	}

	@Override
	public void setVertexValue(Vertex x, Object obj) {
		x.setValue(obj);
	}

	@Override
	public List<Edge> getEdges(Vertex source, Vertex destination) {
		return edges.stream().filter(e -> ((e.getSource().equals(source) && e.getDestination().equals(destination))))
				.collect(Collectors.toList());
	}

	@Override
	public Double getEdgeValue(Edge e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEdgeValue(Edge e, Double weight) {
		// TODO Auto-generated method stub

	}

	@Override
	public Double shortestDistance(Vertex source, Vertex destination) {
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

	@Override
	public DirectionType directionType() {
		return directionType;
	}

	@Override
	public Boolean isDirected() {
		return directionType == DirectionType.DIRECTED;
	}

	@Override
	public void print() {
		int loopCounter = 0;
		// setting values for formatting
		int maxLabelSize = maxLabelSize(vertices) + 1;
		int valuePadding = Math.max(maxLabelSize, maxValueSize(adjacencyMatrix) + 1);
		System.out.print(rpad(" ", maxLabelSize));
		for (Vertex vertex : vertices)
			System.out.print(rpad(vertex.getName(), valuePadding));
		System.out.println();

		for (List<Double> list : adjacencyMatrix) {
			System.out.print(rpad(vertices.get(loopCounter++).getName() + " ", maxLabelSize));
			for (Double value : list) {
				System.out.print(rpad(value + " ", valuePadding));
			}
			System.out.println(" ");
		}
		System.out.println(" ");
	}

	/* ---------------- Util / Helper Classes --------------- */

	private Double initEdgeValue() {
		// current default for initial value
		return DEFAULT_INIT_EDGE_WEIGHT;
	}

	private void initNewEdges() {
		// set rows and cols for new vertex to null
		// if first vertex, handle separtely
		Double value = initEdgeValue();
		Integer size = this.getSize();
		if (size == 1) {
			List<Double> cols = new ArrayList<>();
			cols.add(value);
			adjacencyMatrix.add(cols);
		} else {
			// traverse through each row and add a new col.
			for (List<Double> row : adjacencyMatrix) {
				row.add(value);
			}
			// finally add a new row for new vertex
			List<Double> newRow = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				newRow.add(initEdgeValue());
			}
			adjacencyMatrix.add(newRow);
		}
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

	/**
	 * Get string (chars) size of value
	 * 
	 * @param adjacencyMatrix
	 * @return
	 */
	private int maxValueSize(List<List<Double>> adjacencyMatrix) {
		int maxSize = 0;
		for (List<Double> rows : adjacencyMatrix) {
			for (Double value : rows) {
				int length = (value == null) ? "null".length() : String.valueOf(value).length();
				maxSize = length > maxSize ? length : maxSize;
			}
		}
		return maxSize;
	}

	private void setEdgeWeight(Edge e, Double weight) {
		int sourceIndex = vertices.indexOf(getVertex(e.getSource().getName()));
		int destinationIndex = vertices.indexOf(getVertex(e.getDestination().getName()));
		// Default to graph direction type if edge direction type is not explicitly set
		DirectionType directionType = e.getDirectionType() == null ? this.directionType : e.getDirectionType();

		adjacencyMatrix.get(sourceIndex).set(destinationIndex, weight);
		if (directionType != DirectionType.DIRECTED)
			adjacencyMatrix.get(destinationIndex).set(sourceIndex, weight);
	}

	private Edge getEdge(String source, String destination) {

		Vertex sourceVertex = this.getVertex(source);
		Vertex destinationVertex = this.getVertex(destination);

		for (Edge edge : edges) {
			if (edge.getSource().equals(sourceVertex) && edge.getDestination().equals(destinationVertex))
				return edge;
		}

		return null;
	}

	public void printVertices() {
		vertices.forEach(v -> {
			System.out.print(v + " ");
		});
		System.out.println("");
	}

	public void printEdges() {
		edges.forEach(e -> {
			System.out.print(e + " ");
		});
		System.out.println("");
	}

}
