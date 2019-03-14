package sr.unasat.musiQ_library.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class ArtistInfoDTO {

    private Long id;
    @NotNull
    private ArtistDTO artistDTO;
    @Max(1500)
    private String info;

    public ArtistInfoDTO() {
    }

    public ArtistInfoDTO(ArtistDTO artistDTO, String info) {
        this.artistDTO = artistDTO;
        this.info = info;
    }

    public ArtistInfoDTO(String info) {
        this.info = info;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArtistDTO getArtistDTO() {
        return artistDTO;
    }

    public void setArtistDTO(ArtistDTO artistDTO) {
        this.artistDTO = artistDTO;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
