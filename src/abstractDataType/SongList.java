package abstractDataType;

import Library.Song;

public class SongList extends List<Song>{
	public void arrange(String sort) {
		if(sort == "name") {
			this.quickSortSong(0,this.getLength()-1);
		}
		if (sort == "artist") {
			this.quickSortArtist(0,this.getLength()-1);
		}
		if (sort == "album") {
			this.quickSortAlbum(0,this.getLength()-1);
		}
	}public void quickSortAlbum(int lowerIndex,int higherIndex) {//Quicksort
		int init = lowerIndex;
        int finit = higherIndex;
		
		//calculate pivot number
        Song pivot = this.getValue(init+(finit-init)/2);
        //
        while (init <= finit) {
        	while (this.getValue(init).getAlbum().getName().compareToIgnoreCase(pivot.getAlbum().getName()) <= 0) {
        		if (this.getValue(init).getAlbum().getName().compareToIgnoreCase(pivot.getAlbum().getName()) < 0) {
        			init++;
        		}else {
        			if (this.getValue(init).getName().compareToIgnoreCase(pivot.getName()) < 0) {
            			init++;
        			}
        		}
            }
            while (this.getValue(finit).getAlbum().getName().compareToIgnoreCase(pivot.getAlbum().getName()) >= 0) {
            	if (this.getValue(finit).getAlbum().getName().compareToIgnoreCase(pivot.getAlbum().getName()) > 0) {
        			finit++;
        		}else {
        			if (this.getValue(finit).getName().compareToIgnoreCase(pivot.getName()) > 0) {
            			finit++;
        			}
        		}
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
            quickSortAlbum(lowerIndex, finit);
        if (init < higherIndex)
            quickSortAlbum(init, higherIndex);
	}
	public void quickSortArtist(int lowerIndex,int higherIndex) {//Quicksort
		int init = lowerIndex;
        int finit = higherIndex;
		
		//calculate pivot number
        Song pivot = this.getValue(init+(finit-init)/2);
        //
        while (init <= finit) {
        	while (this.getValue(init).getArtist().getName().compareToIgnoreCase(pivot.getArtist().getName()) <= 0) {
        		if (this.getValue(init).getArtist().getName().compareToIgnoreCase(pivot.getArtist().getName()) < 0) {
        			init++;
        		}else {
        			if (this.getValue(init).getName().compareToIgnoreCase(pivot.getName()) < 0) {
            			init++;
        			}
        		}
            }
            while (this.getValue(finit).getArtist().getName().compareToIgnoreCase(pivot.getArtist().getName()) >= 0) {
            	if (this.getValue(finit).getArtist().getName().compareToIgnoreCase(pivot.getArtist().getName()) > 0) {
        			finit++;
        		}else {
        			if (this.getValue(finit).getName().compareToIgnoreCase(pivot.getName()) > 0) {
            			finit++;
        			}
        		}
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
            quickSortArtist(lowerIndex, finit);
        if (init < higherIndex)
            quickSortArtist(init, higherIndex);
	}
	public void quickSortSong(int lowerIndex,int higherIndex) {//Quicksort
		int init = lowerIndex;
        int finit = higherIndex;
		
		//calculate pivot number
        Song pivot = this.getValue(init+(finit-init)/2);
        //
        while (init <= finit) {
        	while (this.getValue(init).getName().compareToIgnoreCase(pivot.getName()) < 0) {
                init++;
            }
            while (this.getValue(finit).getName().compareToIgnoreCase(pivot.getName()) > 0) {
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
            quickSortSong(lowerIndex, finit);
        if (init < higherIndex)
            quickSortSong(init, higherIndex);
	}
	private void swapSongs(int i, int j) {
        Song temp = this.getValue(i);
        this.swap(this.getValue(j), i);
        this.swap(temp, j);
    }
}
