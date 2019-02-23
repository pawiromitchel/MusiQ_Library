package sr.unasat.musiQ_library.dto;

import sr.unasat.musiQ_library.entity.Song;

public class PlaylistDTO {

    private Long id;
    private String name;
    private Song song;

    public PlaylistDTO(Long id, String name, Song song) {
        this.id = id;
        this.name = name;
        this.song = song;
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

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
