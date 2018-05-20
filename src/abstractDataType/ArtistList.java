package abstractDataType;

import Library.Artist;

public class ArtistList extends List<Artist>{
	public int getMaxChar() {//Gets the max length of word with most characters
		int max=0;
		for (int i = 0; i<this.getLength(); i++) {
			int num = this.getValue(i).getName().length();
			if (num > max) {
				max=num;
			}
		}
		return max;
	}
	public int toValue(String artist, int pos, int arraylen) {//Gets the value of the evaluating character (0-26)
		int value = 0;
		String art = artist.toLowerCase();
		char[] arr = new char[arraylen];
		for (int i=0 ; i < arraylen; i++) {
			if (i < art.length()) {
				if(!Character.isLetter(art.charAt(i))) {//Changes space for accent
					arr[i]= '`';	
				}else {
					arr[i] = art.charAt(i);	
				}
			}else {//Adds accent when finilized
				arr[i] = '`';
			}
		}
		value = (((int) arr[pos])-96);
		return value;
	}
	public void arrange() {//RadixSort
		int max=this.getMaxChar();
		int loop = max;
		Queue<Artist> queue = new Queue <Artist>();
		for (int i=0;i<this.getLength();i++) {
			queue.enqueue(this.getValue(i));
		}
		@SuppressWarnings("unchecked")
		Queue<Artist>[] arr = (Queue<Artist>[]) new Queue[27];
		//Creates a Queue for all the spots in the Array
		for (int i=0; i<27;i++) {
			Queue<Artist> aux = new Queue<Artist>();
			arr[i]=aux;
		}
		while (loop > 0) {
			for(int i=0; i < this.getLength(); i++) {
				int num = toValue(queue.peek().getName(),loop-1,max);
				arr[num].enqueue(queue.peek());
				queue.dequeue();
			}
			for(int i=0; i<27;i++) {
				int large = arr[i].getLength();
				for(int j = 0; j<large; j++) {
					queue.enqueue(arr[i].peek());
					arr[i].dequeue();	
				}
			}
		loop--;
		}
		int large = this.getLength();
		this.erase();
		for (int i=0;i<large;i++) {
			this.add(queue.peek());
			queue.dequeue();
		}
	}
}
