package sr.unasat.musiQ_library.entity;

import javax.persistence.*;
import javax.ws.rs.DefaultValue;
import java.util.List;

@Entity
@Table
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "artist_name", nullable = false, unique = true)
    private String artistName;

    //    @JsonIgnore
    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Album> album;

    @OneToOne
    @JoinColumn(name = "artist_type", nullable = false)
    private ArtistTypeCode artistType;

    @Column(name = "is_followed")
    @DefaultValue(value = "false")
    private boolean isFollowed;

    @OneToOne(mappedBy = "artist", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private ArtistInfo artistInfo;

    public Artist() {
    }

    public Artist(String artistName, ArtistTypeCode artistType, boolean isFollowed) {
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

    public void setArtistName(String name) {
        this.artistName = name;
    }

    public ArtistTypeCode getArtistType() {
        return artistType;
    }

    public void setArtistType(ArtistTypeCode artistType) {
        this.artistType = artistType;
    }

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }

    public boolean isFollowed() {
        return isFollowed;
    }

    public void setFollowed(boolean followed) {
        isFollowed = followed;
    }

    public ArtistInfo getArtistInfo() {
        return artistInfo;
    }

    public void setArtistInfo(ArtistInfo artistInfo) {
        this.artistInfo = artistInfo;
    }
}
