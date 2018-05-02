package Library;
import registry.User;
import trees.*;

public class UserLibrary {
	//Methods
	private String sort;
	private List<Song> songList;
	private AlbumList albumList;
	private ArtistList artistList;
	private Queue<Song> SongQueue;
	//Constructor
	public UserLibrary(User user){
		this.setSongList(user.getSongList());
		this.setAlbumList(user.getAlbumList());
		this.setArtistList(user.getArtistList());
	}
	//Attributes
	public void addSong(Song song){//Adding just one song
		Album auxAlbum = song.getAlbum();
		Artist auxArtist = song.getArtist();
		if (!this.songList.search(song)) {//If the song isn't on the list
			this.songList.add(song);//Adds the song
			if (!this.albumList.search(auxAlbum)) {//Searches if the album isn't on the list
				auxAlbum.getSongs().erase();//Erases the album songs
				auxAlbum.getSongs().add(song);//Adds the song to the album
				this.albumList.add(auxAlbum);//Adds the album
				this.albumList.arrange(sort);//Arranges the Album List
				if (!this.artistList.search(auxArtist)) {
					auxArtist.getAlbums().erase();//Erases the Artist albums
					auxArtist.getAlbums().add(auxAlbum);//Adds the Album to the Artist
					this.artistList.add(auxArtist);//Adds the Artist
					this.artistList.arrange();//Arranges the Artist List
				}else {
					this.artistList.getValue(auxArtist).getAlbums().add(auxAlbum);//Adds the Album to the existing Artist
				}
			}else {
				this.albumList.getValue(song.getAlbum()).getSongs().add(song);//Adds the song to the album
			}
		}	
	}
	public void addAlbum(Album album){//Add the whole album
		Artist auxArtist = album.getArtist();
		if (!this.albumList.search(album)) {
			for(int i=0; i<album.getSongs().getLength();i++) {
				this.songList.add(album.getSongs().getValue(i));
			}
			this.albumList.add(album);
			if (!this.artistList.search(auxArtist)) {
				auxArtist.getAlbums().erase();//Erases the Artist albums
				auxArtist.getAlbums().add(album);//Adds the Album to the Artist
				this.artistList.add(auxArtist);//Adds the Artist
				this.artistList.arrange();//Arranges the Artist List
			}else {
				this.artistList.getValue(auxArtist).getAlbums().add(album);//Adds the Album to the existing Artist
			}
		}else {
			for(int i=0; i<album.getSongs().getLength();i++) {
				if (!this.songList.search(album.getSongs().getValue(i))) {
					this.songList.add(album.getSongs().getValue(i));
				}
			}
			this.albumList.getValue(album).getSongs().empty();
			for(int i=0; i<album.getSongs().getLength();i++) {
				this.albumList.getValue(album).getSongs().add(album.getSongs().getValue(i));
			}
		}
	}
	public void addArtist(Artist artist){//Add the whole discography of the Artist
		if (!this.artistList.search(artist)) {
			
		}
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
	public ArtistList getArtistList() {
		return artistList;
	}
	public void setArtistList(ArtistList artistList) {
		this.artistList = artistList;
	}
	
}
