package trees;

import Library.Album;

public class AlbumList extends List<Album>{
	public Album getValue(String name){
		Album alb=null;
		for (int i=0;i<this.getLength(); i++) {
			if (this.getValue(i).getName() == name) {
				alb=this.getValue(i);
			}
		}
		return alb;
	}
}
