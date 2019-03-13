package sr.unasat.musiQ_library.designPatterns.decorator;

import sr.unasat.musiQ_library.dto.SongDTO;

import java.util.ArrayList;
import java.util.List;

public class AlbumDecorator implements DecoratorBase {

    private List<SongDTO> songList;

    @Override
    public void addSong(SongDTO song) {
        songList = new ArrayList<>();
        songList.add(song);
    }

    @Override
    public List<SongDTO> getSongList() {
        return songList;
    }

    @Override
    public void setSongList(List<SongDTO> songList) {
        this.songList = songList;
    }
}
