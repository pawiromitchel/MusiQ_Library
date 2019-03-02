package sr.unasat.musiQ_library.controller;

import sr.unasat.musiQ_library.config.JPAConfiguration;
import sr.unasat.musiQ_library.dto.AlbumDTO;
import sr.unasat.musiQ_library.dto.SongDTO;
import sr.unasat.musiQ_library.entity.Album;
import sr.unasat.musiQ_library.entity.Song;
import sr.unasat.musiQ_library.service.AlbumService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("album")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlbumController {
    private AlbumService albumService = new AlbumService(JPAConfiguration.getEntityManager());
    private SongController songController = new SongController();

    @Path("/list")
    @GET
    public Response findAll() {
        List<AlbumDTO> albumDTOS = new ArrayList<>();
        List<Album> albums = albumService.findAll();
        for (Album album : albums) {
            albumDTOS.add(convertAlbumToDTO(album));
        }
        return Response.ok(albumDTOS).build();
    }

    @Path("/add")
    @POST
    public Response add(@Valid AlbumDTO albumDTO) {
        try {
            albumService.add(convertDtoToAlbum(albumDTO));
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }

    @Path("/{albumId}")
    @PUT
    public Response update(@PathParam("albumId") Long id, @Valid AlbumDTO albumDTO) {
        try {
            albumDTO.setId(id);
            albumService.update(convertDtoToAlbum(albumDTO));
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }

    @Path("/{albumId}")
    @DELETE
    public Response remove(@PathParam("albumId") Long id) {
        try {
            albumService.delete(id);
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().build();
    }

    @Path("/{albumId}")
    @GET
    public Response getAlbum(@PathParam("albumId") Long id) {
        AlbumDTO albumDTO = null;
        try {
            albumDTO = convertAlbumToDTO(albumService.getAlbum(id));
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(albumDTO).build();
    }

    private AlbumDTO convertAlbumToDTO(Album album) {
        AlbumDTO albumDTO = new AlbumDTO(album.getId(), album.getAlbumTitle(),
                album.getReleaseYear(), album.getArtist());
        if (album.getSongList() != null) {
            List<Song> albumSongs = album.getSongList();
            SongDTO songDTO;
            List<SongDTO> convertedSong = new ArrayList<>();
            for (Song song : albumSongs) {
                songDTO = songController.convertSongToDTO(song);
                convertedSong.add(songDTO);
            }
            albumDTO.setSongList(convertedSong);
        }
        return albumDTO;
    }

    private Album convertDtoToAlbum(AlbumDTO albumDTO) {
        return new Album(albumDTO.getAlbumTitle(), albumDTO.getArtist(),
                albumDTO.getReleaseYear());
    }

    @Path("/{albumId}/songs")
    @GET
    public List<String> getSongsFromAlbum(@PathParam("albumId") Long albumId) {
        AlbumDTO albumDTO = convertAlbumToDTO(albumService.getAlbum(albumId));
        List<SongDTO> songs = albumDTO.getSongs();
        List<String> titles = new ArrayList<>();
        for (SongDTO song : songs) {
            titles.add(song.getTitle());
        }
        return titles;
    }

    @Path("/add/{albumId}/songs")
    @POST
    public void addSongsToAlbum(@PathParam("albumId") Long albumId, @Valid List<SongDTO> songDTOs) {
        List<Song> songs = new ArrayList<>();
        for (SongDTO songDTO : songDTOs) {
            songs.add(songController.convertDtoToSong(songDTO));
        }
        albumService.addSongsToAlbum(albumId, songs);
    }
}
