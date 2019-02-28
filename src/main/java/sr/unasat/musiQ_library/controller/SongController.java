package sr.unasat.musiQ_library.controller;

import sr.unasat.musiQ_library.config.JPAConfiguration;
import sr.unasat.musiQ_library.entity.Song;
import sr.unasat.musiQ_library.service.SongService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("song")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SongController {
    private SongService songService = new SongService(JPAConfiguration.getEntityManager());

    @Path("/list")
    @GET
    public List<Song> findAll() {
        return songService.findAll();
    }

    @Path("/add")
    @POST
    public Song add(Song song) {
        return songService.add(song);
    }

    @Path("/{songId}")
    @PUT
    public Song update(@PathParam("songId") Long id, Song song) {
        song.setId(id);
        return songService.update(song);
    }

    @Path("/{songId}")
    @DELETE
    public void remove(@PathParam("songId") Long id) {
        songService.delete(id);
    }

    @Path("/{songId}")
    @GET
    public Song getSong(@PathParam("songId") Long id) {
        return songService.getSong(id);
    }

}
