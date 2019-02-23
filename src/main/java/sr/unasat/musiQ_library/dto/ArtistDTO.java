package sr.unasat.musiQ_library.dto;


import sr.unasat.musiQ_library.entity.Album;
import sr.unasat.musiQ_library.entity.ArtistTypeCode;

import java.util.List;

public class ArtistDTO {

    private Long id;
    private String artist;
    private List<Album> albumList;
    private ArtistTypeCode artistType;

    public ArtistDTO(Long id, String artist, List<Album> albumList, ArtistTypeCode artistType) {
        this.id = id;
        this.artist = artist;
        this.albumList = albumList;
        this.artistType = artistType;
    }

    public ArtistDTO(Long id, String artist) {
        this.id = id;
        this.artist = artist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    public ArtistTypeCode getArtistType() {
        return artistType;
    }

    public void setArtistType(ArtistTypeCode artistType) {
        this.artistType = artistType;
    }
}
