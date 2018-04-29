package Library;
import trees.List;

public class Artist {
	private String Name;
	private List<Album> Albums;
	
	
	//Getters y Setters
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public List<Album> getAlbums() {
		return Albums;
	}
	public void setAlbums(List<Album> albums) {
		Albums = albums;
	}
	
	

}
