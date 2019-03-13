package sr.unasat.musiQ_library.dto;

import sr.unasat.musiQ_library.entity.Album;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class SongDTO {
    private Long id;
    @NotNull
    private String title;
    @Max(4)
    private int releaseYear;
    private Album album;
    private boolean isFavorite;

    public SongDTO() {
    }

    public SongDTO(String title, int releaseYear, Album album, boolean isFavorite) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.album = album;
        this.isFavorite = isFavorite;
    }

    public SongDTO(String title) {
        this.title = title;
    }

    public SongDTO(Long id, String title, int releaseYear, Album album, boolean isFavorite) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.album = album;
        this.isFavorite = isFavorite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
