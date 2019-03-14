package sr.unasat.musiQ_library.service;

import sr.unasat.musiQ_library.dao.PlaylistDAO;
import sr.unasat.musiQ_library.entity.Playlist;

import javax.persistence.EntityManager;
import java.util.Iterator;
import java.util.List;

public class PlaylistService {

    private PlaylistDAO playlistDAO;
    private List<Playlist> playlists;

    public PlaylistService(EntityManager entityManager) {
        playlistDAO = new PlaylistDAO(entityManager);
        playlists = findAll();
    }

    public List<Playlist> findAll() {
        return playlistDAO.findAllPlaylist();
    }

    public Playlist add(Playlist playlist) {
        playlists.add(playlistDAO.addPlaylist(playlist));
        return playlist;
    }

    public Playlist getPlaylist(Long id) {
        return playlistDAO.findPlaylistById(id);
    }

    public Playlist update(Playlist playlist) {
        Playlist updatedPlaylist = playlistDAO.updatePlaylist(playlist);
        iterate(playlist, updatedPlaylist);
        playlists.add(updatedPlaylist);
        return updatedPlaylist;
    }

    public Playlist delete(Long id) {
        Playlist selectedPlaylist = getPlaylist(id);
        Playlist deletedPlaylist = playlistDAO.deletePlaylist(selectedPlaylist);
        iterate(selectedPlaylist, deletedPlaylist);
        return deletedPlaylist;
    }

    private void iterate(Playlist playlist, Playlist modifiedPlaylist) {
        for (Iterator<Playlist> playlistIterator = playlists.iterator(); playlistIterator.hasNext(); ) {
            playlist = playlistIterator.next();
            if (playlist.getId() == modifiedPlaylist.getId()) {
                playlistIterator.remove();
            }
        }
    }
}

