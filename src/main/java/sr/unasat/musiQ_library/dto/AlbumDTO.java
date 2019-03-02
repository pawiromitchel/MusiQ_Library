package sr.unasat.musiQ_library.dto;

import sr.unasat.musiQ_library.designPatterns.decorator.AlbumDecorator;
import sr.unasat.musiQ_library.designPatterns.decorator.DecoratorBase;
import sr.unasat.musiQ_library.entity.Artist;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.List;

public class AlbumDTO extends AlbumDecorator {
    @NotNull
    private Long id;
    @NotNull
    private String albumTitle;
    @Max(4)
    private int releaseYear;
    @NotNull
    private Artist artist;
    private List<SongDTO> songs;
    private DecoratorBase decoratorBase = new AlbumDecorator();

    public AlbumDTO() {
    }

    public AlbumDTO(Long id, String albumTitle, int releaseYear, Artist artist) {
        this.id = id;
        this.albumTitle = albumTitle;
        this.releaseYear = releaseYear;
        this.artist = artist;
    }

    public AlbumDTO(Long id, String albumTitle, int releaseYear, Artist artist, List<SongDTO> songs) {
        this.id = id;
        this.albumTitle = albumTitle;
        this.releaseYear = releaseYear;
        this.artist = artist;
        this.songs = songs;
    }

    public AlbumDTO(String albumTitle, int releaseYear, Artist artist) {
        this.albumTitle = albumTitle;
        this.releaseYear = releaseYear;
        this.artist = artist;
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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setSongList(List<SongDTO> songList) {
        for (SongDTO song : songList) {
            decoratorBase.addSongs(song);
            songs.add(song);
        }
        this.songs = songList;
    }
}
