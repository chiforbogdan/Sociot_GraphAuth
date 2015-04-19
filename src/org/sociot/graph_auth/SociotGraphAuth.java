package org.sociot.graph_auth;

import java.util.ArrayList;
import java.util.List;

public class SociotGraphAuth {

	private static SociotGraphAuth instance_ = null; /* Singleton instance */

	List<SociotGraphNode> nodes_ = new ArrayList<>(); /* Nodes */

	private static int SOCIOT_GRAPH_TOTAL_AUTH = 100; /*
													 * Total amount of authority
													 * in the system
													 */

	private static final int SOCIOT_VISITED_NODES_WINDOW_SIZE = 5; /*
																	 * Window
																	 * size of
																	 * visited
																	 * nodes
																	 */
	List<SociotGraphNode> visitedNodes_ = new ArrayList<>(); /*
															 * List of visited
															 * nodes
															 */

	private SociotGraphAuth() {

	}

	public static synchronized SociotGraphAuth getInstance() {
		if (instance_ == null) {
			instance_ = new SociotGraphAuth();
		}
		return instance_;
	}

	@Override
	public Object clone() {
		// throw new Exception("Singleton class");
		return instance_;
	}

	public void addNode(SociotGraphNode node) {
		nodes_.add(node);
	}

	private boolean converge() {
		return true;
	}

	private List<SociotGraphNode> getRandomNodeList() {
		List<SociotGraphNode> randomList = new ArrayList<>();
		for (SociotGraphNode node : nodes_) {
			randomList.add(node);
		}
		return randomList;
	}

	private SociotGraphNode getNodes(List<SociotGraphNode> nodeList) {
		if (nodeList == null || nodeList.isEmpty()) {
			return null;
		}
		SociotGraphNode node = nodeList.get(0);
		/* Remove first element */
		nodeList.remove(0);
		return node;
	}

	private SociotGraphNode getNextNode(SociotGraphNode node) {
		return node.getLink();
	}

	private void addVisitedNode(SociotGraphNode node) {
		/* If window is full then we pop the first added element */
		if (visitedNodes_.size() == SOCIOT_VISITED_NODES_WINDOW_SIZE) {
			visitedNodes_.remove(0);
		}
		visitedNodes_.add(node);
	}

	public List<SociotGraphNode> getRanks() {
		/* Set initial authority */
		double initialAuth = ((double) SOCIOT_GRAPH_TOTAL_AUTH / nodes_.size());
		for (SociotGraphNode node : nodes_) {
			node.setAuth(initialAuth);
		}
		/* Compute rank */
		do {
			/* Randomize nodes order */
			List<SociotGraphNode> randomNodes = getRandomNodeList();
			do {
				SociotGraphNode node = getNodes(randomNodes);
				SociotGraphNode newNode = null;
				do {
					/* Mark node as visited */
					addVisitedNode(node);
					newNode = getNextNode(node);
					if (newNode != null) {
						node.passAuth(newNode);
					}
					node = newNode;
				} while (newNode != null);
			} while (!randomNodes.isEmpty());

		} while (!converge());
		return nodes_;
	}
}
