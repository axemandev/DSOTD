package prj.dsotd.simplegraph.model;

public class Edge {

	private Vertex source;
	private Vertex destination;
	private Long weight;
	private DirectionType directionType;
	
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
	public Long getWeight() {
		return weight;
	}
	public void setWeight(Long weight) {
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
