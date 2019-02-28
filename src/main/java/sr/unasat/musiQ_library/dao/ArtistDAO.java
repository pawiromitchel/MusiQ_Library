package sr.unasat.musiQ_library.dao;

import sr.unasat.musiQ_library.entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArtistDAO {

    private EntityManager entityManager;

    public ArtistDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Artist> findAllArtists() {
        entityManager.getTransaction().begin();
        String jpql = "select a from Artist a";
        TypedQuery<Artist> query = entityManager.createQuery(jpql, Artist.class);
        List<Artist> artists = query.getResultList();
        entityManager.getTransaction().commit();
        return artists;
    }

    public Artist addArtist(Artist artist) {
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
        return artist;
    }

    public Artist findArtistById(Long id) {
        entityManager.getTransaction().begin();
        String jpql = "select a from Artist a where a.id = :id";
        TypedQuery<Artist> query = entityManager.createQuery(jpql, Artist.class);
        query.setParameter("id", id);
        Artist foundArtist = query.getSingleResult();
        entityManager.getTransaction().commit();
        return foundArtist;
    }

    public Artist updateArtist(Artist artist) {
        entityManager.getTransaction().begin();
        entityManager.merge(artist);
        entityManager.getTransaction().commit();
        return artist;
    }

    public Artist deleteArtist(Artist artist) {
        entityManager.getTransaction().begin();
        entityManager.remove(artist);
        entityManager.getTransaction().commit();
        return artist;
    }
}
