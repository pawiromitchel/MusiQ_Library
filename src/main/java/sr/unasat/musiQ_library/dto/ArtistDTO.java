package sr.unasat.musiQ_library.dto;


import sr.unasat.musiQ_library.entity.ArtistTypeCode;

import java.util.ArrayList;
import java.util.List;

public class ArtistDTO {

    private Long id;
    private String artistName;
    private List<AlbumDTO> albumList;
    private ArtistTypeCode artistType;
    private boolean isFollowed;

    public ArtistDTO() {
    }

    public ArtistDTO(Long id, String artistName, List<AlbumDTO> albumList,
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

    public List<AlbumDTO> getAlbumList() {
        List<AlbumDTO> dtoList = new ArrayList<>();
        for (AlbumDTO albumDTO : albumList) {
            dtoList.add(new AlbumDTO(albumDTO.getAlbumTitle(), albumDTO.getReleaseYear()));
        }
//        for (int i = 0; i < albumList.size(); i++){
//            albumDTO.setAlbumTitle(albumList.get(i).getAlbumTitle());
//            albumDTO.setReleaseYear(albumList.get(i).getReleaseYear());
//            dtoList.add(albumDTO);
//        }
        return dtoList;
    }

    public void setAlbumList(List<AlbumDTO> albumList) {
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
