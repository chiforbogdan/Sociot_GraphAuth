package org.sociot.graph_auth;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println("-----Sociot Graph Auth Test-----");
		/* Declare nodes */
		SociotGraphNode node1 = new SociotGraphNode(1, "Node 1");
		SociotGraphNode node2 = new SociotGraphNode(2, "Node 2");
		SociotGraphNode node3 = new SociotGraphNode(3, "Node 3");
		SociotGraphNode node4 = new SociotGraphNode(4, "Node 4");
		SociotGraphNode node5 = new SociotGraphNode(5, "Node 5");
		SociotGraphNode node6 = new SociotGraphNode(6, "Node 6");
		SociotGraphNode node7 = new SociotGraphNode(7, "Node 7");
		SociotGraphNode node8 = new SociotGraphNode(8, "Node 8");
		SociotGraphNode node9 = new SociotGraphNode(9, "Node 9");
		SociotGraphNode node10 = new SociotGraphNode(10, "Node 10");
		/* Add node links */
		node1.addLink(node2, 2);
		node1.addLink(node3, 3);
		node1.addLink(node4, 4);
		node1.addLink(node5, 5);
		node1.addLink(node6, 6);
		node6.addLink(node7, 7);
		node7.addLink(node8, 8);
		node8.addLink(node9, 9);
		node9.addLink(node10, 10);

		/* Get ranks */
		SociotGraphAuth.getInstance().addNode(node1);
		SociotGraphAuth.getInstance().addNode(node2);
		SociotGraphAuth.getInstance().addNode(node3);
		SociotGraphAuth.getInstance().addNode(node4);
		SociotGraphAuth.getInstance().addNode(node5);
		SociotGraphAuth.getInstance().addNode(node6);
		SociotGraphAuth.getInstance().addNode(node7);
		SociotGraphAuth.getInstance().addNode(node8);
		SociotGraphAuth.getInstance().addNode(node9);
		SociotGraphAuth.getInstance().addNode(node10);

		List<SociotGraphNode> rankedNodes = SociotGraphAuth.getInstance()
				.getRanks();
		for (SociotGraphNode rankedNode : rankedNodes) {
			System.out.println(rankedNode.getNodeId() + " "
					+ rankedNode.getName());
		}

	}

}
