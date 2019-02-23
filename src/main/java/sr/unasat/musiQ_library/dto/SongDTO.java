package sr.unasat.musiQ_library.dto;

import sr.unasat.musiQ_library.entity.Album;

public class SongDTO {
    private long id;
    private String title;
    private int releaseYear;
    private Album album;
    private boolean isFavorite;

    public SongDTO(long id, String title, int releaseYear, Album album, boolean isFavorite) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.album = album;
        this.isFavorite = isFavorite;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
