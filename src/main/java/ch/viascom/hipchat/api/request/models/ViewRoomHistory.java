package ch.viascom.hipchat.api.request.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Patrick Bösch on 04.05.16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewRoomHistory {
    private String roomId;
    @SerializedName("start-index")
    private int	start_index = 0;
    @SerializedName("max-results")
    private int	max_results = 100;
}
