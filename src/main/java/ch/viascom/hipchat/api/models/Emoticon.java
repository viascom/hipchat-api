package ch.viascom.hipchat.api.models;

import ch.viascom.hipchat.api.models.emoticon.EmoticonType;
import lombok.Data;

/**
 * Created by patrickboesch on 14.04.16.
 */
@Data
public class Emoticon {
    private int id;
    private Member creator;
    private String shortcut;
    private String url;
    private EmoticonType type;
    private int height;
    private int width;
}
