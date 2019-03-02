package sr.unasat.musiQ_library.designPatterns.decorator;

import sr.unasat.musiQ_library.dto.SongDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlbumDecorator implements DecoratorBase {

    private List<SongDTO> songList;

    @Override
    public void addSongs(SongDTO... songs) {
        songList = new ArrayList<>();
        Collections.addAll(songList, songs);
    }

    @Override
    public List<SongDTO> getSongs() {
        return songList;
    }
}
