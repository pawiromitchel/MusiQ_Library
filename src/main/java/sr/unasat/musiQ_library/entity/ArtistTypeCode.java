package sr.unasat.musiQ_library.entity;

import sr.unasat.musiQ_library.designPatterns.state.ArtistState;

import javax.persistence.*;

@Entity
@Table(name = "artist_type_code")
public class ArtistTypeCode extends ArtistState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "artist_type", unique = true, nullable = false)
    private String artistType;

    public ArtistTypeCode() {
    }

    public ArtistTypeCode(String artistType) {
        super(artistType);
    }

    @Override
    public String getArtistType() {
        return artistType;
    }

    @Override
    public void setArtistType(String artistType) {
        this.artistType = artistType;
    }

//    public Artist getArtist() {
//        return artist;
//    }
//
//    public void setArtist(Artist artist) {
//        this.artist = artist;
//    }
}

