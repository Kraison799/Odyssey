package Library;

public class Song {
	private String URL;
	private String name;
	private Artist artist;
	private Album album;
	private int year;
	private int albumIndex;
	
	public Song(String song, Artist artist, Album album, int year, int index){
		this.setName(song);
		this.setArtist(artist);
		this.setAlbum(album);
		this.setYear(year);
		this.setAlbumIndex(index);
	}
	
	//Getter y Setters
	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getAlbumIndex() {
		return albumIndex;
	}

	public void setAlbumIndex(int albumIndex) {
		this.albumIndex = albumIndex;
	}
	
}
