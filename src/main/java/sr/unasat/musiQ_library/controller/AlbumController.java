package sr.unasat.musiQ_library.controller;

import sr.unasat.musiQ_library.config.JPAConfiguration;
import sr.unasat.musiQ_library.entity.Album;
import sr.unasat.musiQ_library.service.AlbumService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("album")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlbumController {
    private AlbumService albumService = new AlbumService(JPAConfiguration.getEntityManager());

    @Path("/list")
    @GET
    public List<Album> findAll() {
        return albumService.findAll();
    }

    @Path("/add")
    @POST
    public Album add(Album album) {
        return albumService.add(album);
    }

    @Path("/{albumId}")
    @PUT
    public Album update(@PathParam("albumId") Long id, Album album) {
        album.setId(id);
        return albumService.update(album);
    }

    @Path("/{albumId}")
    @DELETE
    public void remove(@PathParam("albumId") Long id) {
        albumService.delete(id);
    }

    @Path("/{albumId}")
    @GET
    public Album getSong(@PathParam("albumId") Long id) {
        return albumService.getAlbum(id);
    }

}
