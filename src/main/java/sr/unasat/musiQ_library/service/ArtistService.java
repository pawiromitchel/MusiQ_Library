package sr.unasat.musiQ_library.service;

import sr.unasat.musiQ_library.dao.ArtistDAO;
import sr.unasat.musiQ_library.entity.Artist;

import javax.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;

public class ArtistService {

    private ArtistDAO artistDAO;
    private static List<Artist> artists;

    public ArtistService(EntityManager entityManager) {
        artistDAO = new ArtistDAO(entityManager);
        findAll();
    }

    public List<Artist> findAll() {
        if (artists != null) {
            return artists;
        }
        return artists = artistDAO.findAllArtists();
    }

    public Artist add(Artist artist) {
        artists.add(artistDAO.addArtist(artist));
        return artist;
    }

    public Artist getArtist(Long id) {
        return artistDAO.findArtistById(id);
    }

    public Artist update(Artist artist) {
        Artist updateArtist = artistDAO.updateArtist(artist);
        iterate(artist, updateArtist);
        artists.add(updateArtist);
        return updateArtist;
    }

    public Artist delete(Long id) {
        Artist selectedArtist = getArtist(id);
        if (selectedArtist.getAlbum() != null) {
            selectedArtist.setAlbum(null);
        }
        Artist deletedArtist = artistDAO.deleteArtist(selectedArtist);
        iterate(selectedArtist, deletedArtist);
        return deletedArtist;
    }

    private void iterate(Artist artist, Artist modifiedArtist) {
        for (Iterator<Artist> artistIterator = artists.iterator(); artistIterator.hasNext(); ) {
            artist = artistIterator.next();
            if (artist.getId() == modifiedArtist.getId()) {
                artistIterator.remove();
            }
        }
    }
}

