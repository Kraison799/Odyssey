package trees;

public class Nodo<T> {//T de Type
	private T value;
	private Nodo<T> next;
	
	public Nodo(T object){
		this.setValue(object);
		this.setNext(null);
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Nodo<T> getNext() {
		return next;
	}

	public void setNext(Nodo<T> next) {
		this.next = next;
	}
}
