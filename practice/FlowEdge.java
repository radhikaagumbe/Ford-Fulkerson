package practice;

public class FlowEdge {
	
	private int v;
	private int w;
	private double capacity;
	private double flow;
	
	public FlowEdge(int from, int to, double cap){
		if(from < 0) throw new IllegalArgumentException("vertex index must be a non-negative integer");
		if(to < 0) throw new IllegalArgumentException("vertex index must be a non-negative integer");
		if(!(cap >= 0.0)) throw new IllegalArgumentException("Capacity must be a positive integer");
		v = from;
		w = to;
		capacity = cap;
		flow = 0.0;
	}
	
	public FlowEdge(int from, int to, double cap, double flow){
		if(from < 0) throw new IllegalArgumentException("vertex index must be a non-negative integer");
		if(to < 0) throw new IllegalArgumentException("vertex index must be a non-negative integer");
		if(!(cap >= 0.0)) throw new IllegalArgumentException("Capacity must be a positive integer");
		v = from;
		w = to;
		capacity = cap;
		this.flow = flow;
	}
	
	public FlowEdge(FlowEdge e){
		this.v = e.v;
		this.w = e.w;
		this.capacity = e.capacity;
		this.flow = e.flow;
	}
	
	public int from(){
		return v;
	}
	
	public int to(){
		return w;
	}
	
	public double capacity(){
		return capacity;
	}
	
	public double flow(){
		return flow;
	}
	
	public int other(int vertex){
		if(vertex == v) return w;
		else if(vertex == w) return v;
		else throw new IllegalArgumentException("invalid endpoint");
	}
	
	public double residualCapacityTo(int vertex){
		if(vertex == v) return flow;
		else if(vertex == w) return (capacity - flow);
		else throw new IllegalArgumentException("invalid endpoint");
	}
	
	public void addResidualFlowto(int vertex, double delta){
		if(vertex == v) flow = flow - delta;
		else if(vertex == w) flow = flow + delta;
		else throw new IllegalArgumentException("invalid endpoint");
		
		 if (!(flow >= 0.0))      throw new IllegalArgumentException("Flow is negative");
	     if (!(flow <= capacity)) throw new IllegalArgumentException("Flow exceeds capacity");

	}
	
	public String toString() {
        return v + "->" + w + " " + flow + "/" + capacity;
    }
	
	public static void main(String[] args) {
        FlowEdge e = new FlowEdge(12, 23, 4.56);
        System.out.println(e);
    }
}
