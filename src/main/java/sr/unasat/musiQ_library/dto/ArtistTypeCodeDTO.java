package sr.unasat.musiQ_library.dto;

import sr.unasat.musiQ_library.designPatterns.state.ArtistState;

public class ArtistTypeCodeDTO extends ArtistState {

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

