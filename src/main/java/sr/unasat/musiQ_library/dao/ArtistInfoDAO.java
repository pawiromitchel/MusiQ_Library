package sr.unasat.musiQ_library.dao;

import sr.unasat.musiQ_library.entity.ArtistInfo;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ArtistInfoDAO {

    private EntityManager entityManager;
    private List<ArtistInfo> artistInfoList;

    public ArtistInfoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
        artistInfoList = findAllInfo();
    }

    public List<ArtistInfo> findAllInfo() {
        entityManager.getTransaction().begin();
        String jpql = "select ai from ArtistInfo ai join Artist a on a.id = ai.artist.id";
        TypedQuery<ArtistInfo> query = entityManager.createQuery(jpql, ArtistInfo.class);
        artistInfoList = query.getResultList();
        entityManager.getTransaction().commit();
        return artistInfoList;
    }

    public ArtistInfo addInfo(ArtistInfo artistInfo) {
        entityManager.getTransaction().begin();
        entityManager.persist(artistInfo);
        entityManager.getTransaction().commit();
        return artistInfo;
    }

    public ArtistInfo findInfoByArtistId(Long id) {
        entityManager.getTransaction().begin();
        String jpql = "select ai from ArtistInfo ai join Artist a where a.id = :id";
        TypedQuery<ArtistInfo> query = entityManager.createQuery(jpql, ArtistInfo.class);
        query.setParameter("id", id);
        ArtistInfo playlist = query.getSingleResult();
        entityManager.getTransaction().commit();
        return playlist;
    }

    public ArtistInfo updateInfo(ArtistInfo artistInfo) {
        entityManager.getTransaction().begin();
        entityManager.merge(artistInfo);
        entityManager.getTransaction().commit();
        return artistInfo;
    }

    public ArtistInfo deleteInfo(ArtistInfo artistInfo) {
        entityManager.getTransaction().begin();
        entityManager.remove(artistInfo);
        entityManager.getTransaction().commit();
        return artistInfo;
    }
}
