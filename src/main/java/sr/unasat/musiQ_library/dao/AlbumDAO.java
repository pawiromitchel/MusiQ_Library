package sr.unasat.musiQ_library.dao;

import sr.unasat.musiQ_library.entity.Album;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlbumDAO {

    private EntityManager entityManager;

    public AlbumDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Album> findAllAlbums() {
        entityManager.getTransaction().begin();
        String jpql = "select a from Album a";
        TypedQuery<Album> query = entityManager.createQuery(jpql, Album.class);
        List<Album> albums = query.getResultList();
        entityManager.getTransaction().commit();
        return albums;
    }

    public Album addAlbum(Album album) {
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
        return album;
    }

    public Album findAlbumById(Long id) {
        entityManager.getTransaction().begin();
        String jpql = "select a from Album a where a.id = :id";
        TypedQuery<Album> query = entityManager.createQuery(jpql, Album.class);
        query.setParameter("id", id);
        Album foundAlbum = query.getSingleResult();
        entityManager.getTransaction().commit();
        return foundAlbum;
    }

    public Album updateAlbum(Album album) {
        entityManager.getTransaction().begin();
        entityManager.merge(album);
        entityManager.getTransaction().commit();
        return album;
    }

    public Album deleteAlbum(Album album) {
        entityManager.getTransaction().begin();
        entityManager.remove(album);
        entityManager.getTransaction().commit();
        return album;
    }
}
