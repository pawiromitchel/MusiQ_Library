package sr.unasat.musiQ_library.dao;

import sr.unasat.musiQ_library.entity.Playlist;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PlaylistDAO {

    private EntityManager entityManager;

    public PlaylistDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Playlist> findAllPlaylist() {
        entityManager.getTransaction().begin();
        String jpql = "select p from Playlist p";
        TypedQuery<Playlist> query = entityManager.createQuery(jpql, Playlist.class);
        List<Playlist> playlists = query.getResultList();
        entityManager.getTransaction().commit();
        return playlists;
    }

    public Playlist addPlaylist(Playlist playlist) {
        entityManager.getTransaction().begin();
        entityManager.persist(playlist);
        entityManager.getTransaction().commit();
        return playlist;
    }

    public Playlist findPlaylistById(Long id) {
        entityManager.getTransaction().begin();
        String jpql = "select p from Playlist p where p.id = :id";
        TypedQuery<Playlist> query = entityManager.createQuery(jpql, Playlist.class);
        query.setParameter("id", id);
        Playlist playlist = query.getSingleResult();
        entityManager.getTransaction().commit();
        return playlist;
    }

    public Playlist updatePlaylist(Playlist playlist) {
        entityManager.getTransaction().begin();
        entityManager.merge(playlist);
        entityManager.getTransaction().commit();
        return playlist;
    }

    public Playlist deletePlaylist(Playlist playlist) {
        entityManager.getTransaction().begin();
        entityManager.remove(playlist);
        entityManager.getTransaction().commit();
        return playlist;
    }
}
