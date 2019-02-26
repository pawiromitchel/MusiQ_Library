package sr.unasat.musiQ_library.dao;

import sr.unasat.musiQ_library.entity.Song;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class SongDAO {

    private EntityManager entityManager;
    private List<Song> songList;

    public SongDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Song> findAllSongs() {
        entityManager.getTransaction().begin();
        String jpql = "select s from Song s";
        TypedQuery<Song> query = entityManager.createQuery(jpql, Song.class);
        songList = query.getResultList();
        entityManager.getTransaction().commit();
        return songList;
    }
}
