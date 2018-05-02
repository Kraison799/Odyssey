package trees;

public class Queue<Type> {
	private Nodo<Type> head;
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
	}
	public void dequeue() {
		if (head != null){
			head=head.getNext();
		}
	}
	public Type peek() {
		return head.getValue();
	}
}
