package sr.unasat.musiQ_library.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "playlist_name", nullable = false, unique = true)
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Song> songs;

    public Playlist() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> song) {
        this.songs = song;
    }
}
