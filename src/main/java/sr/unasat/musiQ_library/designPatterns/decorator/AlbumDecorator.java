package sr.unasat.musiQ_library.designPatterns.decorator;

import sr.unasat.musiQ_library.dto.SongDTO;

import java.util.ArrayList;
import java.util.List;

public class AlbumDecorator implements DecoratorBase {

    private List<SongDTO> songList = new ArrayList<>();

    @Override
    public void addSong(SongDTO song) {
        songList = new ArrayList<>();
        songList.add(song);
    }

    @Override
    public List<String> getSongList() {
        List<String> dtoList = new ArrayList<>();
        for (int i = 0; i < songList.size(); i++) {
            dtoList.add(songList.get(i).getTitle());
        }
        return dtoList;
    }

    @Override
    public void setSongList(List<SongDTO> songList) {
        this.songList = songList;
    }
}
