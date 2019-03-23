package sr.unasat.musiQ_library.dto;

import sr.unasat.musiQ_library.designPatterns.decorator.AlbumDecorator;
import sr.unasat.musiQ_library.entity.Artist;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class AlbumDTO extends AlbumDecorator {
    private Long id;
    @NotNull
    private String albumTitle;
    @Max(4)
    private int releaseYear;
    @NotNull
    private Artist artistName;

    public AlbumDTO() {
    }

    public AlbumDTO(String albumTitle, Artist artistName, int releaseYear) {
        this.albumTitle = albumTitle;
        this.artistName = artistName;
        this.releaseYear = releaseYear;
    }

    public AlbumDTO(String albumTitle, int releaseYear) {
        this.albumTitle = albumTitle;
        this.releaseYear = releaseYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getArtistName() {
        return artistName.getArtistName();
    }

    public void setArtistName(Artist artistName) {
        this.artistName = artistName;
    }
}
