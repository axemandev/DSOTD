package prj.dsotd.simplegraph.model;

public class Edge {

	private Vertex source;
	private Vertex destination;
	private Integer weight;
	private DirectionType directionType;
	
	public Edge() {
		super();
	}
	
	public Edge (Vertex source, Vertex destination) {
		this(source, destination, 0, null);
	}
	
	public Edge (Vertex source, Vertex destination, Integer weight) {
		this(source, destination, weight, null);
	}
	
	public Edge (Vertex source, Vertex destination, Integer weight, DirectionType directionType) {
		setSource(source);
		setDestination(destination);
		setWeight(weight);
		setDirectionType(directionType);
	}
	
	public Vertex getSource() {
		return source;
	}
	public void setSource(Vertex source) {
		this.source = source;
	}
	public Vertex getDestination() {
		return destination;
	}
	public void setDestination(Vertex destination) {
		this.destination = destination;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public DirectionType getDirectionType() {
		return directionType;
	}
	public void setDirectionType(DirectionType directionType) {
		this.directionType = directionType;
	}
	
	@Override
	public String toString() {
		return "Edge [source=" + source + ", destination=" + destination + ", weight=" + weight + ", directionType="
				+ directionType + "]";
	}
}
