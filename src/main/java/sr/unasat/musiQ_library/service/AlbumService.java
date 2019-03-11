package sr.unasat.musiQ_library.service;

import sr.unasat.musiQ_library.dao.AlbumDAO;
import sr.unasat.musiQ_library.entity.Album;
import sr.unasat.musiQ_library.entity.Artist;
import sr.unasat.musiQ_library.entity.Song;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlbumService {

    private AlbumDAO albumDAO;
    private ArtistService artistService;
    private SongService songService;
    private static List<Album> albums;

    public AlbumService(EntityManager entityManager) {
        albumDAO = new AlbumDAO(entityManager);
        artistService = new ArtistService(entityManager);
        songService = new SongService(entityManager);
        findAll();
    }

    public List<Album> findAll() {
        return albums = albumDAO.findAllAlbums();
    }

    public Album add(Album album) {
        List<Artist> artists = artistService.findAll();
        for (Artist artist : artists) {
            if (!artist.getArtistName().toLowerCase().equals(album.getArtist().getArtistName().toLowerCase())) {
                artistService.add(album.getArtist());
                break;
            }
        }
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

    public void addSongsToAlbum(Long albumId, List<String> songs) {
        Album album = getAlbum(albumId);
        List<Song> songList = new ArrayList<>();
        for (String song : songs) {
            Song addedSong = songService.add(new Song(song, album.getReleaseYear(), album, false));
            songList.add(addedSong);
        }
        album.setSongList(songList);
        update(album);
    }


}

