package sr.unasat.musiQ_library.service;

import sr.unasat.musiQ_library.dao.AlbumDAO;
import sr.unasat.musiQ_library.entity.Album;

import javax.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;

public class AlbumService {

    private AlbumDAO albumDAO;
    private static List<Album> albums;

    public AlbumService(EntityManager entityManager) {
        albumDAO = new AlbumDAO(entityManager);
        findAll();
    }

    public List<Album> findAll() {
        if (albums != null) {
            return albums;
        }
        return albums = albumDAO.findAllAlbums();
    }

    public Album add(Album album) {
        albums.add(albumDAO.addAlbum(album));
        return album;
    }

    public Album getAlbum(Long id) {
        return albumDAO.findAlbumById(id);
    }

    public Album update(Album album) {
        Album updatedAlbum = albumDAO.updateAlbum(album);
        iterate(album, updatedAlbum);
        albums.add(updatedAlbum);
        return updatedAlbum;
    }

    public Album delete(Long id) {
        Album selectedAlbum = getAlbum(id);
        Album deletedAlbum = albumDAO.deleteAlbum(selectedAlbum);
        iterate(selectedAlbum, deletedAlbum);
        return deletedAlbum;
    }

    private void iterate(Album album, Album modifiedAlbum) {
        for (Iterator<Album> albumIterator = albums.iterator(); albumIterator.hasNext(); ) {
            album = albumIterator.next();
            if (album.getId() == modifiedAlbum.getId()) {
                albumIterator.remove();
            }
        }
    }
}

