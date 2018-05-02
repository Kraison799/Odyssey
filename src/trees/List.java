package trees;

public class List<T> {
	//Atributos
	private Nodo<T> head;
	private int length;
	//Constructor

	//Validador de Lista Vacia
	public boolean empty(){
		return head == null;
	}
	//Metodos
	public void add(T value){//Agregar un miembro a la hilera al final
		Nodo<T> New = new Nodo<T>(value);
		if (empty()){
			head = New;
		}
		else{
			Nodo<T> aux = head;
			while(aux.getNext() != null){
				aux=aux.getNext();
			}
			aux.setNext(New);
		}
		length++;
	}
	public boolean search(T reference){
		Nodo<T> aux = head;
		boolean flag=false;
		while (aux != null && flag != true){
			if (reference == aux.getValue()){
				flag = true;
			}
			else{
				aux = aux.getNext();
			}
		}
	return flag;
	}
	void delete(T reference){//Elimina un miembro por referencia
		if (search(reference)){
			if (head.getValue() == reference){
				head = head.getNext();
			}
			else{
				Nodo<T> aux = head;
				while(aux.getNext().getValue() != reference){
					aux = aux.getNext();
				}
				Nodo<T> next = aux.getNext().getNext();
				aux.setNext(next);
			}
			length--;
		}
	}
	public T getValue(T reference){
		Nodo<T> aux = head;
		T object=null;
		while (aux != null && object == null){
			if (reference == aux.getValue()){
				object = aux.getValue();
			}
			else{
				aux = aux.getNext();
			}
		}
		return object;
	}
	public void erase(){//Elimina la lista
		head = null;
		length = 0;
	}
	public T getValue(int pos) {//Obtener valor por referencia
		if(pos >= 0 && pos < length) {
			if (pos == 0){
				return head.getValue();
			}else {
				Nodo<T> aux = head;
				for (int i = 0; i < pos; i++) {
					aux = aux.getNext();
				}
				return aux.getValue();
			}
		}else {
			return null;
		}
	}
	public void swap(T reference,int pos) {
		if(pos >= 0 && pos < length) {
			if (pos == 0){
				head.setValue(reference);
			}else {
				Nodo<T> aux = head;
				for (int i = 0; i < pos; i++) {
					aux = aux.getNext();
				}
				aux.setValue(reference);
			}
		}
	}
	//Getters y Setters
	public Nodo<T> getHead() {
		return head;
	}

	public void setHead(Nodo<T> head) {
		this.head = head;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
}
