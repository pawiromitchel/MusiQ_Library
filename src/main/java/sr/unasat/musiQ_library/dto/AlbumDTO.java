package sr.unasat.musiQ_library.dto;

import sr.unasat.musiQ_library.entity.Artist;
import sr.unasat.musiQ_library.entity.Song;

import java.util.List;

public class AlbumDTO {
    private long id;
    private String albumTitle;
    private int releaseYear;
    private Artist artist;
    private List<Song> songList;

    public AlbumDTO(long id, String albumTitle, int releaseYear) {
        this.id = id;
        this.albumTitle = albumTitle;
        this.releaseYear = releaseYear;
    }

    public AlbumDTO(long id, String albumTitle, int releaseYear, Artist artist) {
        this.id = id;
        this.albumTitle = albumTitle;
        this.releaseYear = releaseYear;
        this.artist = artist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
}
