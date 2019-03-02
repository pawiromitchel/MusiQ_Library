package sr.unasat.musiQ_library.controller;

import sr.unasat.musiQ_library.config.JPAConfiguration;
import sr.unasat.musiQ_library.dto.SongDTO;
import sr.unasat.musiQ_library.entity.Song;
import sr.unasat.musiQ_library.service.SongService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("song")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SongController {
    private SongService songService = new SongService(JPAConfiguration.getEntityManager());

    @Path("/list")
    @GET
    public Response findAll() {
        List<SongDTO> songDTOS = new ArrayList<>();
        List<Song> songs = songService.findAll();
        for (Song song : songs) {
            songDTOS.add(setSongInfo(song));
        }
        return Response.status(Response.Status.OK).entity(songDTOS).build();
    }

    @Path("/add")
    @POST
    public Response add(@Valid SongDTO songDTO) {
        try {
            songService.add(getSongDTOInfo(songDTO));
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.OK).build();
    }

    @Path("/{songId}")
    @PUT
    public Response update(@PathParam("songId") Long id, @Valid SongDTO songDTO) {
        try {
            songDTO.setId(id);
            songService.update(getSongDTOInfo(songDTO));
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.OK).build();
    }

    @Path("/{songId}")
    @DELETE
    public Response remove(@PathParam("songId") Long id) {
        try {
            songService.delete(id);
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.OK).build();
    }

    @Path("/{songId}")
    @GET
    public Response getSong(@PathParam("songId") Long id) {
        Song song = null;
        try {
            song = songService.getSong(id);
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(song, MediaType.APPLICATION_JSON).build();
    }

    private SongDTO setSongInfo(Song song) {
        return new SongDTO(song.getId(), song.getTitle(),
                song.getReleaseYear(), song.getAlbum(), song.isFavorite());
    }

    private Song getSongDTOInfo(SongDTO songDTO) {
        if (songDTO.getAlbum() != null) {
            return new Song(songDTO.getTitle(),
                    songDTO.getReleaseYear(), songDTO.getAlbum(), songDTO.isFavorite());
        }
        return new Song(songDTO.getTitle(),
                songDTO.getReleaseYear(), songDTO.isFavorite());
    }

}
