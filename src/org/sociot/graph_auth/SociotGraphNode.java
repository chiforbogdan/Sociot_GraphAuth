package org.sociot.graph_auth;

import java.util.ArrayList;
import java.util.List;

public class SociotGraphNode {
	int nodeId_; /* Node id */
	double nodeAuth_; /* Node auth value */
	String nodeName_; /* Node name */
	List<SociotGraphLink> links_ = new ArrayList<SociotGraphLink>(); /*
																	 * Node
																	 * links
																	 */

	/**
	 * Ctor
	 * 
	 * @param nodeId
	 *            Node identifier
	 * @param name
	 *            Node name
	 */
	public SociotGraphNode(int nodeId, String name) {
		nodeId_ = nodeId;
		nodeName_ = name;
	}

	/**
	 * Get node id
	 */
	public int getNodeId() {
		return nodeId_;
	}

	/**
	 * Set auth value
	 * 
	 * @param auth
	 *            Auth value
	 */
	public void setAuth(double auth) {
		nodeAuth_ = auth;
	}

	/**
	 * Pass amount of authority to given node
	 * 
	 * @param node
	 *            Node which receives the authority
	 */
	public void passAuth(SociotGraphNode node) {

	}

	/**
	 * Get auth value
	 * 
	 * @return Auth value
	 */
	public double getAuth() {
		return nodeAuth_;
	}

	/**
	 * Add neighbour
	 * 
	 * @param node
	 *            Neighbour node
	 * @param weight
	 *            Link weight
	 */
	public void addLink(SociotGraphNode node, int weight) {
		links_.add(new SociotGraphLink(node, weight));
	}

	/**
	 * Get node name
	 * 
	 * @return Node name
	 */
	public String getName() {
		return nodeName_;
	}

	public SociotGraphNode getLink() {
		if (links_.isEmpty()) {
			return null;
		}
		/* FIXME add probability */
		return links_.get(0).getNode();
	}
}
