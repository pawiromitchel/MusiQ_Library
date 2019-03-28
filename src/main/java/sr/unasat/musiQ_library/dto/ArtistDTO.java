package sr.unasat.musiQ_library.dto;


import java.util.ArrayList;
import java.util.List;

public class ArtistDTO {

    private Long id;
    private String artistName;
    private List<AlbumDTO> album = new ArrayList<>();
    private ArtistTypeCodeDTO artistType;
    private boolean isFollowed;
    private ArtistInfoDTO artistInfo;

    public ArtistDTO() {
    }

    public ArtistDTO(Long id, String artistName, List<AlbumDTO> album,
                     ArtistTypeCodeDTO artistType, boolean isFollowed) {
        this.id = id;
        this.artistName = artistName;
        this.album = album;
        this.artistType = artistType;
        this.isFollowed = isFollowed;
    }

    public ArtistDTO(Long id, String artistName, ArtistTypeCodeDTO artistType, boolean isFollowed) {
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

    public List<String> getAlbum() {
        List<String> dtoList = new ArrayList<>();
        for (AlbumDTO albumDTO : album) {
            dtoList.add(albumDTO.getAlbumTitle());
        }
//        for (int i = 0; i < album.size(); i++){
//            albumDTO.setAlbum(album.get(i).getAlbum());
//            albumDTO.setReleaseYear(album.get(i).getReleaseYear());
//            dtoList.add(albumDTO);
//        }
        return dtoList;
    }

    public void setAlbum(List<AlbumDTO> album) {
        this.album = album;
    }

    public String getArtistType() {
        return artistType.getArtistType();
    }

    public void setArtistType(ArtistTypeCodeDTO artistType) {
        this.artistType = artistType;
    }

    public boolean isFollowed() {
        return isFollowed;
    }

    public void setFollowed(boolean followed) {
        isFollowed = followed;
    }

    public ArtistInfoDTO getArtistInfo() {
        return artistInfo;
    }

    public void setArtistInfo(ArtistInfoDTO artistInfo) {
        this.artistInfo = artistInfo;
    }
}
