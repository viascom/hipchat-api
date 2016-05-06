package ch.viascom.hipchat.api.models;

import ch.viascom.hipchat.api.models.emoticon.EmoticonType;
import lombok.Data;

/**
 * Created by patrickboesch on 14.04.16.
 */
@Data
public class Emoticon {
    /**
     * ID of the emoticon.
     */
    private int id;

    /**
     * The path to the audio file that should accompany this emoticon or not
     * !IMPORTANT! Not implemented  by hipchat
     */
    //@SerializedName("audio_path")
    //private String audioPath;

    /**
     * !NOT IN API REFERENCE!
     */
    private Member creator;

    /**
     * The shortcut text to use to invoke this emoticon in chat
     */
    private String shortcut;

    /**
     * The URL to the emoticon image file
     */
    private String url;

    /**
     * !NOT IN API REFERENCE!
     */
    private EmoticonType type;

    /**
     * The height of the emoticon in pixels
     */
    private int height;

    /**
     * The width of the emoticon in pixels
     */
    private int width;
}
