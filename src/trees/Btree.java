package trees;

public class Btree implements Tree{
	
	private static int order;
	
	Bnode root;
	
	
	public Btree(int order)
	{
		this.order = order;
		root = new Bnode(order, null);
	}
	@Override
	public void add() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Node node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object song) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object mp3, Node node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findMin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findMin(Node node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findMax() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findMax(Node node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void search(Object song) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void search(Object song, Node node) {
		// TODO Auto-generated method stub
		
	}

}
