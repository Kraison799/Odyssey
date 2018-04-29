	package trees;

public class Bnode implements Node<Object>{
	private int order;  //variable to determine order of tree
	private int count; // number of keys in node
	private int key[];  // array of key values
	private Bnode child[]; //array of references
	private boolean leaf; //is node a leaf or not
	private Bnode parent;  //parent of current node
	
	public Bnode(int order, Bnode parent)
	{
		this.setOrder(order);  //assign size
		this.setParent(parent); //assign parent
		key = new int[2*order - 1];  // array of proper size
		child = new Bnode[2*order]; // array of refs proper size
		setLeaf(true); // every node is leaf at first;
		setCount(0); //until we add keys later.
	}
	@Override
	public void setValue() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getValue(int index) {
		// TODO Auto-generated method stub
		return key[index];
	}
	public Bnode getChild(int index)
	{
		return child[index];
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public Bnode getParent() {
		return parent;
	}
	public void setParent(Bnode parent) {
		this.parent = parent;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}

}
