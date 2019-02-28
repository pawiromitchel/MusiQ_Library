package sr.unasat.musiQ_library.controller;

import sr.unasat.musiQ_library.config.JPAConfiguration;
import sr.unasat.musiQ_library.entity.Playlist;
import sr.unasat.musiQ_library.service.PlaylistService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("playlist")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlaylistController {
    private PlaylistService playlistService = new PlaylistService(JPAConfiguration.getEntityManager());

    @Path("/list")
    @GET
    public List<Playlist> findAll() {
        return playlistService.findAll();
    }

    @Path("/add")
    @POST
    public Playlist add(Playlist playlist) {
        return playlistService.add(playlist);
    }

    @Path("/{playlistId}")
    @PUT
    public Playlist update(@PathParam("playlistId") Long id, Playlist playlist) {
        playlist.setId(id);
        return playlistService.update(playlist);
    }

    @Path("/{playlistId}")
    @DELETE
    public void remove(@PathParam("playlistId") Long id) {
        playlistService.delete(id);
    }

    @Path("/{playlistId}")
    @GET
    public Playlist getSong(@PathParam("playlistId") Long id) {
        return playlistService.getPlaylist(id);
    }

}
