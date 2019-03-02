package sr.unasat.musiQ_library.designPatterns.decorator;

import sr.unasat.musiQ_library.dto.SongDTO;

import java.util.List;

public interface DecoratorBase {

    void addSongs(SongDTO... songs);

    List<SongDTO> getSongs();

}
