package sr.unasat.musiQ_library.dto;

import sr.unasat.musiQ_library.designPatterns.decorator.AlbumDecorator;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class AlbumDTO extends AlbumDecorator {
    private Long id;
    @NotNull
    private String albumTitle;
    @Max(4)
    private int releaseYear;
    @NotNull
    private ArtistDTO artist;

    public AlbumDTO() {
    }

    public AlbumDTO(String albumTitle, ArtistDTO artist, int releaseYear) {
        this.albumTitle = albumTitle;
        this.artist = artist;
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

    public String getArtist() {
        return artist.getArtistName();
    }

    public void setArtist(ArtistDTO artist) {
        this.artist = artist;
    }
}
