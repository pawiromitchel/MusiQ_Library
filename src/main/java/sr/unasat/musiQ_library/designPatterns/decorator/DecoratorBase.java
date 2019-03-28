package sr.unasat.musiQ_library.designPatterns.decorator;

import sr.unasat.musiQ_library.entity.Artist;

public interface DecoratorBase {

    Artist getArtist();

    void setArtist(Artist artist);

}
