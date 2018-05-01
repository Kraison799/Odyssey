package registry;

import Library.Artist;
import Library.Song;
import trees.AlbumList;
import trees.List;

public class User {

    private String userName;
    private String fullName;
    private int age;
    private List favoriteGenres;
    private String password;
    private String amigos;
    private List<Artist> artistList;
    private AlbumList albumList;
    private List<Song> songList;
    private List playlist;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List getFavoriteGenres() {
        return favoriteGenres;
    }

    public void setFavoriteGenres(List favoriteGenres) {
        this.favoriteGenres = favoriteGenres;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAmigos() {
        return amigos;
    }

    public void setAmigos(String amigos) {
        this.amigos = amigos;
    }

    public List<Artist> getArtistList() {
        return artistList;
    }

    public void setArtistList(List<Artist> artistList) {
        this.artistList = artistList;
    }

    public AlbumList getAlbumList() {
        return albumList;
    }

    public void setAlbumList(AlbumList albumList) {
        this.albumList = albumList;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public List getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List playlist) {
        this.playlist = playlist;
    }
}
