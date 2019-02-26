package sr.unasat.musiQ_library.service;

import sr.unasat.musiQ_library.dao.SongDAO;
import sr.unasat.musiQ_library.entity.Song;

import javax.persistence.EntityManager;
import java.util.List;

public class SongService {

    private static Long id;
    private SongDAO songDAO;
    private List<Song> songList;

    public SongService(EntityManager entityManager) {
        songDAO = new SongDAO(entityManager);
    }

    public List<Song> findAll() {
        return songDAO.findAllSongs();
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

