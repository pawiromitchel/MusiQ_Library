package sr.unasat.musiQ_library.dto;


import sr.unasat.musiQ_library.entity.ArtistTypeCode;

import java.util.ArrayList;
import java.util.List;

public class ArtistDTO {

    private Long id;
    private String artistName;
    private List<AlbumDTO> albumTitle = new ArrayList<>();
    private ArtistTypeCode artistType;
    private boolean isFollowed;
    private ArtistInfoDTO artistInfo;

    public ArtistDTO() {
    }

    public ArtistDTO(Long id, String artistName, List<AlbumDTO> albumTitle,
                     ArtistTypeCode artistType, boolean isFollowed) {
        this.id = id;
        this.artistName = artistName;
        this.albumTitle = albumTitle;
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

    public List<String> getAlbumTitle() {
        List<String> dtoList = new ArrayList<>();
        for (AlbumDTO albumDTO : albumTitle) {
            dtoList.add(albumDTO.getAlbumTitle());
        }
//        for (int i = 0; i < albumTitle.size(); i++){
//            albumDTO.setAlbumTitle(albumTitle.get(i).getAlbumTitle());
//            albumDTO.setReleaseYear(albumTitle.get(i).getReleaseYear());
//            dtoList.add(albumDTO);
//        }
        return dtoList;
    }

    public void setAlbumTitle(List<AlbumDTO> albumTitle) {
        this.albumTitle = albumTitle;
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

    public String getArtistInfo() {
        return artistInfo.getInfo();
    }

    public void setArtistInfo(ArtistInfoDTO artistInfo) {
        this.artistInfo = artistInfo;
    }
}
