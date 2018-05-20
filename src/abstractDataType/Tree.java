package abstractDataType;

public interface Tree<T> {
	public void add();
	public void add(Node node);
	public void delete(T song);
	public void delete(T mp3 ,Node node);
	public void findMin();
	public void findMin(Node node);
	public void findMax();
	public void findMax(Node node);
	public void search(T song);
	public void search(T song, Node node);
	
	
}
