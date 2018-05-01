package Library;
import registry.User;
import trees.*;

public class UserLibrary {
	//Methods
	private List<Song> songList;
	private AlbumList albumList;
	private List<Artist> artistList;
	//Constructor
	public UserLibrary(User user){
		this.setSongList(user.getSongList());
		this.setAlbumList(user.getAlbumList());
		this.setAlbumList(albumList);
	}
	//Attributes
	public void addSong(Song song){
		if (!this.songList.search(song)) {
			this.songList.add(song);
			if (!this.albumList.search(song.getAlbum())) {
				this.albumList.add(song.getAlbum());
			}else {
				this.albumList.getValue(song.getAlbum().getName()).getSongs().add(song);
			}
			if (!this.artistList.search(song.getArtist())) {
				this.artistList.add(song.getArtist());
			}
		}
		
		
	}
	public void addAlbum(){
		
	}
	public void addArtist(){
		
	}
	public void setLibrary(){
		
	}
	public void deleteSong(){
		
	}
	
	public void deleteAlbum(){
		
	}
	public void deleteArtist(){
		
	}
	//Getters y Setters
	public List<Song> getSongList() {
		return songList;
	}
	public void setSongList(List<Song> songList) {
		this.songList = songList;
	}
	public List<Album> getAlbumList() {
		return albumList;
	}
	public void setAlbumList(AlbumList albumList) {
		this.albumList = albumList;
	}
	public List<Artist> getArtistList() {
		return artistList;
	}
	public void setArtistList(List<Artist> artistList) {
		this.artistList = artistList;
	}
	
}
