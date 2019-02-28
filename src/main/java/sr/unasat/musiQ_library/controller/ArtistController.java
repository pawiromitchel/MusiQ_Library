package sr.unasat.musiQ_library.controller;

import sr.unasat.musiQ_library.config.JPAConfiguration;
import sr.unasat.musiQ_library.entity.Artist;
import sr.unasat.musiQ_library.service.ArtistService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("artist")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ArtistController {
    private ArtistService artistService = new ArtistService(JPAConfiguration.getEntityManager());

    @Path("/list")
    @GET
    public List<Artist> findAll() {
        return artistService.findAll();
    }

    @Path("/add")
    @POST
    public Artist add(Artist artist) {
        return artistService.add(artist);
    }

    @Path("/{artistId}")
    @PUT
    public Artist update(@PathParam("artistId") Long id, Artist artist) {
        artist.setId(id);
        return artistService.update(artist);
    }

    @Path("/{artistId}")
    @DELETE
    public void remove(@PathParam("artistId") Long id) {
        artistService.delete(id);
    }

    @Path("/{artistId}")
    @GET
    public Artist getSong(@PathParam("artistId") Long id) {
        return artistService.getArtist(id);
    }

}
