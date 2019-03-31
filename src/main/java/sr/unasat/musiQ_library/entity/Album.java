package sr.unasat.musiQ_library.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import sr.unasat.musiQ_library.designPatterns.decorator.DecoratorBase;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Album implements DecoratorBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "album_title", nullable = false)
    private String albumTitle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @Column(name = "release_year", nullable = false)
    private int releaseYear;

    @JsonIgnore
    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Song> songList;

    public Album() {
    }

    public Album(String albumTitle, Artist artist, int releaseYear) {
        this.albumTitle = albumTitle;
        this.artist = artist;
        this.releaseYear = releaseYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumName) {
        this.albumTitle = albumName;
    }

    @Override
    public Artist getArtist() {
        return artist;
    }

    @Override
    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    public List<Song> getSongList() {
        return songList;
    }
}
