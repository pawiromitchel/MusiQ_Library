package sr.unasat.musiQ_library.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "album_title")
    private String albumTitle;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Artist artist;

    @Column(name = "release_year", nullable = false)
    private int releaseYear;

    @OneToMany(mappedBy = "album")
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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
}
