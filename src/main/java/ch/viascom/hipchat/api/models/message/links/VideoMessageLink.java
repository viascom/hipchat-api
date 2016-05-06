package ch.viascom.hipchat.api.models.message.links;

import lombok.Data;

/**
 * Created by patrickboesch on 21.04.16.
 */
@Data
public class VideoMessageLink implements MessageLinkContent {
    private String thumbnailUrl;
    private int views;
    private String author;
    private String title;
}
