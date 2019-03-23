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
    private Album albumTitle;
    private boolean isFavorite;

    public SongDTO() {
    }

    public SongDTO(String title, int releaseYear, Album albumTitle, boolean isFavorite) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.albumTitle = albumTitle;
        this.isFavorite = isFavorite;
    }

    public SongDTO(String title) {
        this.title = title;
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

    public String getArtist() {
        return albumTitle.getArtist().getArtistName();
    }

    public String getAlbumTitle() {
        return albumTitle.getAlbumTitle();
    }

    public void setAlbumTitle(Album albumTitle) {
        this.albumTitle = albumTitle;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
