package ch.viascom.hipchat.api.models.card;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by patrickboesch on 11.04.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardIcon {
    private String url;
    @SerializedName("url@2x")
    private String url2x; //REPLACE with url@2x
}
