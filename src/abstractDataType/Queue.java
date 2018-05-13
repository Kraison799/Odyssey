package abstractDataType;

public class Queue<Type> {
	private Nodo<Type> head;
	private int length;
	public void empty() {
		head=null;
	}
	public void enqueue(Type object) {
		Nodo<Type> aux = new Nodo<Type>(object);
		if (head == null) {
			head=aux;
		}else {
			Nodo<Type> current=head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(aux);
		}
		length++;
	}
	public void dequeue() {
		if (head != null){
			head=head.getNext();
		}
		length--;
	}
	public Type peek() {
		return head.getValue();
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
}
