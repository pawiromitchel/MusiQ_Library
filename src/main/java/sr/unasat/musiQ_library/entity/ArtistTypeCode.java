package sr.unasat.musiQ_library.entity;

import java.util.HashMap;
import java.util.Map;

public enum ArtistTypeCode {

    SOLO("Solo"),
    DUO("Duo"),
    GROUP("Group"),
    BAND("BAND");

    private final String value;

    ArtistTypeCode(String value) {
        this.value = value;
    }

    public static Map<String, String> toList() {
        Map<String, String> map = new HashMap<>();
        for (ArtistTypeCode artistType : ArtistTypeCode.values()) {
            map.put(artistType.name(), artistType.getValue());
        }
        return map;
    }

    public String getValue() {
        return value;
    }
}
