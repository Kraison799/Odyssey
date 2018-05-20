package registry;

import abstractDataType.ArtistList;
import abstractDataType.List;
import abstractDataType.SongList;
import abstractDataType.AlbumList;

import java.security.NoSuchAlgorithmException;

public class User implements Comparable<User>{

    private String userName;
    private String fullName;
    private int age;
    private List favoriteGenres;
    private String password;
    private String friends;
    private ArtistList artistList;
    private AlbumList albumList;
    private SongList songList;
    private List playlist;

    public User(String username, String name, int age) {
        this.userName = username;
        this.password = name;
        this.age = age;
    }

    public User(){}

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

    public String getPassword() throws NoSuchAlgorithmException {
        Digest digest = new Digest();
        return digest.toMD5(password);
    }

    public void setPassword(String password) throws NoSuchAlgorithmException {
        this.password = password;
        Digest digest = new Digest();
        this.password = digest.toMD5(password);
    }

    public String getFriends() {
        return friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }

    public ArtistList getArtistList() {
        return artistList;
    }

    public void setArtistList(ArtistList artistList) {
        this.artistList = artistList;
    }

    public AlbumList getAlbumList() {
        return albumList;
    }

    public void setAlbumList(AlbumList albumList) {
        this.albumList = albumList;
    }

    public SongList getSongList() {
        return songList;
    }

    public void setSongList(SongList songList) {
        this.songList = songList;
    }

    public List getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List playlist) {
        this.playlist = playlist;
    }

    @Override
    public int compareTo(User user){
        if (getUserName().compareTo(user.getUserName()) < 0){
            return -1;
        }else if (getUserName().compareTo(user.getUserName()) > 0){
            return 1;
        }else{
            return 0;
        }
    }
}
