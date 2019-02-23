package sr.unasat.musiQ_library.dto;

import sr.unasat.musiQ_library.entity.Artist;

public class SongDTO {
    private long id;
    private String title;
    private int releaseYear;
    private Artist artist;

    public SongDTO(long id, String title, int releaseYear, Artist artist) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.artist = artist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

}
