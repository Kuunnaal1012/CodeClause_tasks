import java.util.ArrayList;
import java.util.List;

class Song {
    private String title;
    private String artist;
    private String album;
    // Other song properties and methods

    public Song(String title, String artist, String album) {
        this.title = title;
        this.artist = artist;
        this.album = album;
    }

    // Getters and setters for song properties
}

class Playlist {
    private String name;
    private List<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }

    // Other playlist methods
}

class User {
    private String username;
    private String password;
    private List<Playlist> playlists;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.playlists = new ArrayList<>();
    }

    public void createPlaylist(String name) {
        Playlist playlist = new Playlist(name);
        playlists.add(playlist);
    }

    public void deletePlaylist(Playlist playlist) {
        playlists.remove(playlist);
    }

    // Other user methods
}

public class MusicStreamingApp {
    public static void main(String[] args) {
        // Create songs
        Song song1 = new Song("Title 1", "Artist 1", "Album 1");
        Song song2 = new Song("Title 2", "Artist 2", "Album 2");

        // Create playlists
        Playlist playlist1 = new Playlist("My Playlist 1");
        playlist1.addSong(song1);
        playlist1.addSong(song2);

        // Create user and associate playlists
        User user = new User("username", "password");
        user.createPlaylist("My Playlist 2");
        user.deletePlaylist(playlist1);

        
        List<Playlist> playlists = user.getPlaylists();
        for (Playlist playlist : playlists) {
            List<Song> songs = playlist.getSongs();
            for (Song song : songs) {
                System.out.println(song.getTitle() + " - " + song.getArtist());
            }
        }
    }
}
