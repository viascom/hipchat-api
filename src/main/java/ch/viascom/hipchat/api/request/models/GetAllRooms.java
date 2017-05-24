package ch.viascom.hipchat.api.request.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by patrickboesch on 12.04.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllRooms implements Serializable {
    @SerializedName("start-index")
    private int	start_index = 0;
    @SerializedName("max-results")
    private int	max_results = 100;
    @SerializedName("include-private")
    boolean	include_private = true;
    @SerializedName("include-archived")
    boolean	include_archived = false;
}
