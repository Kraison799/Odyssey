package abstractDataType;

import Library.Album;

public class AlbumList extends List<Album>{
	/* No sé si esto será necesario
	public Album getValue(String name){
		Album alb=null;
		for (int i=0;i<this.getLength(); i++) {
			if (this.getValue(i).getName() == name) {
				alb=this.getValue(i);
			}
		}
		return alb;
	}
	*/
	public void arrange(String sort) {//Bubblesort
		if (sort == "name") {//Orden alfabético del Album
			boolean sorted = false;
			int large = this.getLength()-1;
			while(!sorted) {
				sorted = true;
				for (int index = 0; index < large; index++) {
					String albumName1 = this.getValue(index).getName();
					String albumName2 = this.getValue(index+1).getName();
					if (albumName1.compareToIgnoreCase(albumName2) > 0) {
						sorted = false;
						Album hold = this.getValue(index+1);
						this.swap(this.getValue(index), index+1);
						this.swap(hold,index);
					}
				}
				large--;
			}
		}
		else if (sort == "year") {//Año
			boolean sorted = false;
			int large = this.getLength()-1;
			while(!sorted) {
				sorted = true;
				for (int index = 0; index < large; index++) {
					int albumYear1 = this.getValue(index).getYear();
					int albumYear2 = this.getValue(index+1).getYear();
					if (albumYear1 > albumYear2) {
						Album hold = this.getValue(index+1);
						this.swap(this.getValue(index), index+1);
						this.swap(hold,index);
					}
				}
				large--;
			}
		}
		if (sort == "artist and album") {//Orden alfabético del Artista y Album
			boolean sorted = false;
			int large = this.getLength()-1;
			while(!sorted) {
				sorted = true;
				for (int index = 0; index < large; index++) {
					String artistName1 = this.getValue(index).getArtist().getName();
					String artistName2 = this.getValue(index+1).getArtist().getName();
					if (artistName1.compareToIgnoreCase(artistName2) > 0) {
						Album hold = this.getValue(index+1);
						this.swap(this.getValue(index), index+1);
						this.swap(hold,index);
					}else if(artistName1.compareToIgnoreCase(artistName2) == 0) {
						String albumName1 = this.getValue(index).getName();
						String albumName2 = this.getValue(index+1).getName();
						if (albumName1.compareToIgnoreCase(albumName2) > 0) {
							Album hold = this.getValue(index+1);
							this.swap(this.getValue(index), index+1);
							this.swap(hold,index);
						}
					}
				}
				large--;
			}
		}
		if (sort == "artist and year") {//Orden alfabético del Artista y Año
			boolean sorted = false;
			int large = this.getLength()-1;
			while(!sorted) {
				sorted = true;
				for (int index = 0; index < large; index++) {
					String artistName1 = this.getValue(index).getArtist().getName();
					String artistName2 = this.getValue(index+1).getArtist().getName();
					if (artistName1.compareToIgnoreCase(artistName2) > 0) {
						Album hold = this.getValue(index+1);
						this.swap(this.getValue(index), index+1);
						this.swap(hold,index);
					}else if(artistName1.compareToIgnoreCase(artistName2) == 0) {
						int albumYear1 = this.getValue(index).getYear();
						int albumYear2 = this.getValue(index+1).getYear();
						if (albumYear1 > albumYear2) {
							Album hold = this.getValue(index+1);
							this.swap(this.getValue(index), index+1);
							this.swap(hold,index);
						}
					}
				}
			large--;
			}
		}
	}	
}