package org.sociot.graph_auth;

public class SociotGraphLink {
	private SociotGraphNode node_; /* Node where link points to */
	private int linkWeight_; /* Link weight */

	/**
	 * Ctor
	 * 
	 * @param node
	 *            Node where link points to
	 * @param linkWeight
	 *            Link weight
	 */
	public SociotGraphLink(SociotGraphNode node, int linkWeight) {
		node_ = node;
		linkWeight_ = linkWeight;
	}

	/**
	 * Get node
	 * 
	 * @return Node
	 */
	public SociotGraphNode getNode() {
		return node_;
	}

	/**
	 * Get Link weight
	 * 
	 * @return Link weight
	 */
	public int getLinkWeight() {
		return linkWeight_;
	}
}
