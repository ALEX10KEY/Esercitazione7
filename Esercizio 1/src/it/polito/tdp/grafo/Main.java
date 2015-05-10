package it.polito.tdp.grafo;

import java.util.*;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

public class Main {

	private List<Integer> vertices ;
	private SimpleDirectedGraph<Integer, DefaultEdge> graph ;

	
	public Main() {
		this.vertices = new LinkedList<Integer>() ;
		this.graph = new SimpleDirectedGraph<Integer, DefaultEdge>(DefaultEdge.class);
	}

	public void load() {
		for (int i=1 ; i<=7 ; i++)
			this.vertices.add(i) ; 
	}
	
	private void buildGraph() {
		Graphs.addAllVertices(graph, this.vertices);
		this.graph.addEdge(1, 2) ;
		this.graph.addEdge(2, 5) ;
		this.graph.addEdge(5, 1) ;
		this.graph.addEdge(5, 4) ;
		this.graph.addEdge(4, 3) ;
		this.graph.addEdge(7, 3) ;
		this.graph.addEdge(3, 6) ;
		this.graph.addEdge(6, 4) ;
		this.graph.addEdge(4, 6) ;
	}
	
	
	public SimpleDirectedGraph<Integer, DefaultEdge> getGraph() {
		return graph;
	}

	public void printSuccessors() {
		for ( Integer vertex : this.vertices  ) {
			List<Integer> successors = Graphs.successorListOf(graph, vertex) ;
			System.out.println( String.format("Vertice : %d , Successori diretti : %s", vertex, successors) ); 
		}
	}
	
	public static void main(String[] args) {
		
		Main m = new Main() ;
		m.load();
		m.buildGraph();
		System.out.println(m.getGraph());
		m.printSuccessors();
	}

}
