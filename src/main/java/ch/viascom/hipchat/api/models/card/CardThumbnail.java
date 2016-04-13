package ch.viascom.hipchat.api.models.card;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Created by patrickboesch on 11.04.16.
 */
@Data
public class CardThumbnail {
    private String url;
    private int width;
    @SerializedName("url@2x")
    private String url2x; //REPLACE with url@2x
    private int height;
}
