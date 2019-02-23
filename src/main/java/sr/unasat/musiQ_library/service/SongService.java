package sr.unasat.musiQ_library.service;

import sr.unasat.musiQ_library.entity.Artist;
import sr.unasat.musiQ_library.entity.ArtistTypeCode;
import sr.unasat.musiQ_library.entity.Song;

import java.util.ArrayList;
import java.util.List;

public class SongService {

    private static List<Song> songList;
    private static Long id;

    public SongService() {
        if (songList == null) {
            id = 0L;
            songList = new ArrayList<>();
            songList.add(new Song(++id, "Living on A Prayer", 1986, false));
            songList.add(new Song(++id, "Bohemian Rhapsody", 1986, true));
            songList.add(new Song(++id, "The Real Slim Shady", 2000, true));
        }
    }

    public List<Song> findAll() {
        return songList;
    }

    public Song add(Song song) {
        song.setId(++id);
        songList.add(song);
        return song;
    }

    public Song getSong(Song song) {
        Song foundSong = new Song();

        for (int i = 0; i< songList.size(); i++) {
            if(songList.get(i).getId() == song.getId())
            {
                foundSong = songList.get(i);
                break;
            }
        }

        return foundSong;
    }

    public Song update(Song song) {
        for (int i = 0; i< songList.size(); i++) {
            if(songList.get(i).getId() == song.getId())
            {
                songList.set(i, song);
                break;
            }
        }

        return song;
    }

    public Song delete(Song song) {
       int index = -1;

        for (int i = 0; i< songList.size(); i++) {
            if(songList.get(i).getId() == song.getId())
            {
                index = i;
                break;
            }
        }
        Song songTemp = new Song();
        songTemp = songList.get(index);

        songList.remove(index);
        return songTemp;
    }

}

