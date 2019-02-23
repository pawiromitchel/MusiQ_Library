package sr.unasat.musiQ_library.dto;

import sr.unasat.musiQ_library.entity.Album;

public class AlbumDTO {
    private long id;
    private String albumTitle;
    private int releaseYear;
    private Album album;

    public AlbumDTO(long id, String albumTitle, int releaseYear) {
        this.id = id;
        this.albumTitle = albumTitle;
        this.releaseYear = releaseYear;
    }

    public AlbumDTO(long id, String albumTitle, int releaseYear, Album album) {
        this.id = id;
        this.albumTitle = albumTitle;
        this.releaseYear = releaseYear;
        this.album = album;
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

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
