package sr.unasat.musiQ_library.dao;

import sr.unasat.musiQ_library.entity.Song;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SongDAO {

    private EntityManager entityManager;
    private List<Song> songList;

    public SongDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        findAllSongs();
    }

    public List<Song> findAllSongs() {
        entityManager.getTransaction().begin();
        String jpql = "select s from Song s";
        TypedQuery<Song> query = entityManager.createQuery(jpql, Song.class);
        songList = query.getResultList();
        entityManager.getTransaction().commit();
        return songList;
    }

    public Song addSong(Song song) {
        entityManager.getTransaction().begin();
        List<Song> list = new ArrayList<>();
        for (int i = 0; i < songList.size(); i++) {
            if (songList.get(i).getTitle().equals(song.getTitle())) {
                continue;
            }
            list = songList.stream().filter(s -> songList.contains(!s.getTitle().equals(song.getTitle())))
                    .collect(Collectors.toList());
            entityManager.persist(song);
            entityManager.getTransaction().commit();
        }
        return song;
    }

    public Song findSongById(Long id) {
        entityManager.getTransaction().begin();
        String jpql = "select s from Song s where s.id = :id";
        TypedQuery<Song> query = entityManager.createQuery(jpql, Song.class);
        query.setParameter("id", id);
        Song foundSong = query.getSingleResult();
        entityManager.getTransaction().commit();
        return foundSong;
    }

    public Song updateSong(Song song) {
        entityManager.getTransaction().begin();
        entityManager.merge(song);
        entityManager.getTransaction().commit();
        return song;
    }

    public Song deleteSong(Song songToBeDeleted) {
        entityManager.getTransaction().begin();
        entityManager.remove(songToBeDeleted);
        entityManager.getTransaction().commit();
        return songToBeDeleted;
    }
}
