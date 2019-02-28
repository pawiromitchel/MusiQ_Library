package sr.unasat.musiQ_library.service;

import sr.unasat.musiQ_library.dao.SongDAO;
import sr.unasat.musiQ_library.entity.Song;

import javax.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;

public class SongService {

    private SongDAO songDAO;
    private static List<Song> songList;

    public SongService(EntityManager entityManager) {
        songDAO = new SongDAO(entityManager);
        findAll();
    }

    public List<Song> findAll() {
        if (songList != null) {
            return songList;
        }
        return songList = songDAO.findAllSongs();
    }

    public Song add(Song song) {
        songList.add(songDAO.addSong(song));
        return song;
    }

    public Song getSong(Long id) {
        return songDAO.findSongById(id);
    }

    public Song update(Song song) {
        Song updatedSong = songDAO.updateSong(song);
        iterate(song, updatedSong);
        songList.add(updatedSong);
        return updatedSong;
    }

    public Song delete(Long id) {
        Song selectedSong = getSong(id);
        Song deletedSong = songDAO.deleteSong(selectedSong);
        iterate(selectedSong, deletedSong);
        return deletedSong;
    }

    private void iterate(Song song, Song modifiedSong) {
        for (Iterator<Song> songIterator = songList.iterator(); songIterator.hasNext(); ) {
            song = songIterator.next();
            if (song.getId() == modifiedSong.getId()) {
                songIterator.remove();
            }
        }
    }
}

