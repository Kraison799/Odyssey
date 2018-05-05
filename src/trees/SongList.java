package trees;

import Library.Song;

public class SongList extends List<Song>{
	public void arrange() {
		this.quickSort(0,this.getLength());
	}
	public void quickSort(int lowerIndex,int higherIndex) {//Quicksort
		int init = lowerIndex;
        int finit = higherIndex;
		
		Song i = this.getValue(init);
		Song j = this.getValue(finit);
		//calculate pivot number
        Song pivot = this.getValue(init+(finit-init)/2);
        //
        while (init <= finit) {
        	while (i.getName().compareToIgnoreCase(pivot.getName()) < 0) {
                init++;
            }
            while (j.getName().compareToIgnoreCase(pivot.getName()) > 0) {
                finit--;
            }
            if (init <= finit) {
                swapSongs(init, finit);
                //move index to next position on both sides
                init++;
                finit--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < finit)
            quickSort(lowerIndex, finit);
        if (init < higherIndex)
            quickSort(init, higherIndex);
	}
	private void swapSongs(int i, int j) {
        Song temp = this.getValue(i);
        this.swap(this.getValue(j), i);
        this.swap(temp, j);
    }
}
