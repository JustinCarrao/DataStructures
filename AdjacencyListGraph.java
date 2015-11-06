package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class AdjacencyListGraph {
	
	List<GraphNode> myNodes;
	PriorityQueue<GraphNode> pQ;
	
	public AdjacencyListGraph(List<GraphNode> nodes) {
		//myNodes = new ArrayList<GraphNode>();
		myNodes = nodes;
	}
	
	public AdjacencyListGraph() {
		myNodes = new ArrayList<GraphNode>();
	}
	
	public boolean adjacent(GraphNode g1, GraphNode g2) {
		for (GraphNode g: g1.children.keySet()) {
			if (g == g2) return true;
		}
		return false;
	}
	
	public List<GraphNode> neighbors(GraphNode g1) { //O(n) time and O(n) space
		List<GraphNode> neighbors = new ArrayList<GraphNode>();
		for (GraphNode g: g1.children.keySet()) {
			neighbors.add(g);
		}
		return neighbors;
	}
	
	public List<GraphNode> neighbors(Node g1) { //O(n) time and O(n) space
		List<GraphNode> neighbors = new ArrayList<GraphNode>();
		for (GraphNode n: myNodes) {
			if (n.data == g1.data) {
				return neighbors(n);
			}
		}
		return neighbors;
	}
	
	public int numNeighbors(GraphNode g) { //O(n) time and O(n) space
		return g.children.keySet().size();
	}
	
	public void addNode(GraphNode g) {
		if (!myNodes.contains(g)) myNodes.add(g);
	}
	
	public void removeVertex(GraphNode g) {
		if (myNodes.contains(g)) myNodes.remove(g);
	}
	
	public void addEdge(GraphNode g1, GraphNode g2) {
		g1.children.put(g2, 1);
	}
	
	public void addEdge(GraphNode g1, GraphNode g2, int weight) {
		g1.children.put(g2, weight);
	}
	
	public void removeEdge(GraphNode g1, GraphNode g2) {
		if (g1.children.containsKey(g2)) g1.children.remove(g2);
	}
	
	public void removeConnection(GraphNode g1, GraphNode g2) {
		if (g1.children.containsKey(g2)) g1.children.remove(g2);
		if (g2.children.containsKey(g2)) g2.children.remove(g1);
	}
	
	public int getValue(GraphNode g2) {
		return g2.data;
	}
	
	public void setValue(GraphNode g2, int value) {
		g2.data = value;
	}
	
	public int getEdgeValue(GraphNode g1, GraphNode g2) {
		if (g1.children.containsKey(g2)) return g1.children.get(g2);
		return 0;
	}
	
	public int numNodes() {
		return myNodes.size();
	}
	
	public int numEdges() {
		int count = 0;
		for (GraphNode node: myNodes) {
			count += neighbors(node).size();
		}
		return count;
	}
	
	public List<Node> bfsFind(GraphNode n) {
		List<Node> reachables = new ArrayList<Node>();
		Queue Q = new Queue(n);
		Node current = new GraphNode();
		while (Q.size() > 0) {
			current = Q.pop();
			for (GraphNode ni: neighbors(current)) {
				if (!reachables.contains(ni)) {
					Q.push(ni);
				}
				reachables.add(current);
			}
		}
		return reachables;
	}
	
	public List<Node> dfsFind(GraphNode n) {
		List<Node> reachables = new ArrayList<Node>();
		Stack Q = new Stack(n);
		Node current = new GraphNode();
		while (Q.size() > 0) {
			current = Q.pop();
			for (GraphNode ni: neighbors(current)) {
				if (!reachables.contains(ni)) {
					Q.push(ni);
				}
				reachables.add(current);
			}
		}
		return reachables;
	}
	
	public HashMap<GraphNode, Integer> dijkstra(GraphNode g) {
		HashMap<GraphNode, Integer> dists = new HashMap<GraphNode, Integer>();
		HashMap<GraphNode, GraphNode> prevs = new HashMap<GraphNode, GraphNode>();
		PriorityQueue<GraphNode> pQ = new PriorityQueue<GraphNode>(myNodes.size(), 
				new Comparator<GraphNode>() {
					public int compare(GraphNode n1, GraphNode n2) {
						return dists.get(n1) - dists.get(n2);
					}
				}
		);
		for (GraphNode node: myNodes) {
			if (node != g) {
				dists.put(node, 100);
			}
			else {
				dists.put(node, 0);
			}
			prevs.put(node, null);
			pQ.add(node);
		}
		dists.put(g, 0);
		GraphNode g1 = new GraphNode();
		while (pQ.size() > 0) {
			g1 = pQ.poll();
			for (GraphNode child: neighbors(g1)) {
				int alt = dists.get(g1) + g1.children.get(child);
				if (alt < 0) {
					alt = alt*(-1);
				}
				if (alt < dists.get(child)) {
					dists.put(child, alt);
					prevs.put(child, g1);
				}
			}
		}
		return dists;		
	}
	
	public ArrayList<GraphNode> dijkstraReconstruct(GraphNode g, GraphNode gi) {
		HashMap<GraphNode, Integer> dists = new HashMap<GraphNode, Integer>();
		HashMap<GraphNode, GraphNode> prevs = new HashMap<GraphNode, GraphNode>();
		ArrayList<GraphNode> path = new ArrayList<GraphNode>();
		PriorityQueue<GraphNode> pQ = new PriorityQueue<GraphNode>(myNodes.size(), 
				new Comparator<GraphNode>() {
					public int compare(GraphNode n1, GraphNode n2) {
						return dists.get(n1) - dists.get(n2);
					}
				}
		);
		
		for (GraphNode node: myNodes) {
			if (node != g) {
				dists.put(node, 100);
			}
			else {
				dists.put(node, 0);
			}
			prevs.put(node, null);
			pQ.add(node);
		}
		dists.put(g, 0);
		GraphNode g1 = new GraphNode();
		while (pQ.size() > 0) {
			g1 = pQ.poll();
			
			for (GraphNode child: neighbors(g1)) {
				int alt = dists.get(g1) + g1.children.get(child);
				if (alt < 0) {
					alt = alt*(-1);
				}
				if (alt < dists.get(child)) {
				
					dists.put(child, alt);
					prevs.put(child, g1);
				}
			}
		}
		if (prevs.containsKey(gi)) {
			path.add(gi);
			GraphNode current = prevs.get(gi);
			while (current != g) {
				path.add(current);
				current = prevs.get(current);
			}
			path.add(g);
		}
		return path;
	}
	
}
	
	
	
	
	


