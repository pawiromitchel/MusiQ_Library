package sr.unasat.musiQ_library.dto;


import sr.unasat.musiQ_library.entity.Album;
import sr.unasat.musiQ_library.entity.ArtistTypeCode;

import java.util.List;

public class ArtistDTO {

    private Long id;
    private String artistName;
    private List<Album> albumList;
    private ArtistTypeCode artistType;
    private boolean isFollowed;

    public ArtistDTO(Long id, String artistName, List<Album> albumList,
                     ArtistTypeCode artistType, boolean isFollowed) {
        this.id = id;
        this.artistName = artistName;
        this.albumList = albumList;
        this.artistType = artistType;
        this.isFollowed = isFollowed;
    }

    public ArtistDTO(Long id, String artistName, ArtistTypeCode artistType, boolean isFollowed) {
        this.id = id;
        this.artistName = artistName;
        this.artistType = artistType;
        this.isFollowed = isFollowed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
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

    public boolean isFollowed() {
        return isFollowed;
    }

    public void setFollowed(boolean followed) {
        isFollowed = followed;
    }
}
