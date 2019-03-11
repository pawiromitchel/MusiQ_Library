package sr.unasat.musiQ_library.controller;

import org.modelmapper.ModelMapper;
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
    private ModelMapper modelMapper = new ModelMapper();

    @Path("/list")
    @GET
    public Response findAll() {
        List<SongDTO> songDTOS = new ArrayList<>();
        List<Song> songs = songService.findAll();
        SongDTO songDTO;
        for (Song song : songs) {
            songDTO = modelMapper.map(song, SongDTO.class);
            songDTOS.add(songDTO);
        }
        return Response.ok(songDTOS).build();
    }

    @Path("/add")
    @POST
    public Response add(@Valid SongDTO songDTO) {
        try {
            Song song = modelMapper.map(songDTO, Song.class);
            songService.add(song);
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
            Song song = modelMapper.map(songDTO, Song.class);
            songService.update(song);
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
        SongDTO songDTO;
        try {
            songDTO = modelMapper.map(songService.getSong(id), SongDTO.class);
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(songDTO).build();
    }

}
