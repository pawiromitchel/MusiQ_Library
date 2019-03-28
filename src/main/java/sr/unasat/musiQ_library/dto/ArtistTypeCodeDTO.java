package sr.unasat.musiQ_library.dto;

public class ArtistTypeCodeDTO {

    private Long id;

    private String artistType;

    public ArtistTypeCodeDTO() {
    }

    public ArtistTypeCodeDTO(String artistType) {
        this.artistType = artistType;
    }

    public String getArtistType() {
        return artistType;
    }

    public void setArtistType(String artistType) {
        this.artistType = artistType;
    }

}

