package Library;
import abstractDataType.*;
import registry.User;

public class UserLibrary {
	//Methods
	private String sort;
	private SongList songList;
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
			if (!this.albumList.search(auxAlbum)) {//Searches if the album isn't on the list
				auxAlbum.getSongs().erase();//Erases the album songs
				auxAlbum.getSongs().add(song);//Adds the song to the album
				this.albumList.add(auxAlbum);//Adds the album
				if (!this.artistList.search(auxArtist)) {
					auxArtist.getAlbums().erase();//Erases the Artist albums
					auxArtist.getAlbums().add(auxAlbum);//Adds the Album to the Artist
					this.artistList.add(auxArtist);//Adds the Artist
				}else {
					this.artistList.getValue(auxArtist).getAlbums().add(auxAlbum);//Adds the Album to the existing Artist
				}
			}else {
				this.albumList.getValue(song.getAlbum()).getSongs().add(song);//Adds the song to the album
			}
		}
		this.albumList.arrange(sort);
		this.songList.arrange(sort);
		this.artistList.arrange();
		
	}
	public void addAlbum(Album album){//Add the whole album
		for (int i=0;i<album.getSongs().getLength();i++) {
			this.addSong(album.getSongs().getValue(i));
		}
	}
	public void addArtist(Artist artist) {
		for (int i=0;i<artist.getAlbums().getLength();i++) {
			this.addAlbum(artist.getAlbums().getValue(i));
		}
	}
	public void setLibrary(){
		
	}
	public void deleteSong(Song song){
		if (this.songList.search(song)) {
			this.songList.delete(song);
			if (song.getAlbum().getSongs().getLength()==1) {
				this.albumList.delete(song.getAlbum());
				if (song.getArtist().getAlbums().getLength()==1) {
					this.artistList.delete(song.getArtist());
				}
			}
		}
		this.albumList.arrange(sort);
		this.songList.arrange(sort);
		this.artistList.arrange();
	}
	
	public void deleteAlbum(Album album){
		if (this.albumList.search(album)) {
			for (int i=0;i<album.getSongs().getLength();i++) {
				this.deleteSong(album.getSongs().getValue(i));
			}
		}
	}
	public void deleteArtist(Artist artist) {
		if (this.artistList.search(artist)) {
			for (int i=0;i<artist.getAlbums().getLength();i++) {
				this.deleteAlbum(artist.getAlbums().getValue(i));
			}
		}
	}
	//Getters y Setters
	public SongList getSongList() {
		return songList;
	}
	public void setSongList(SongList songList) {
		this.songList = songList;
	}
	public AlbumList getAlbumList() {
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
